package br.com.biblioteca.service;

import br.com.biblioteca.exception.LivroNaoEncontradoException;
import br.com.biblioteca.exception.ValidacaoException;
import br.com.biblioteca.repository.LivroRepository;
import br.com.biblioteca.enums.CategoriaLivro;
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.validacao.ValidarLivro;

import java.util.ArrayList;

import static br.com.biblioteca.util.GeradorIdUtil.gerarProximoIdLivro;

public class LivroService {

    // atributos
    private final LivroRepository livroRepository = new LivroRepository();
    private final ArrayList<Livro> livros = livroRepository.carregarLivros();
    private final ValidarLivro validarLivro = new ValidarLivro();

    // métodos
    public void cadastrarLivro(
            String titulo,
            String autor,
            int anoLancamento,
            CategoriaLivro categoria,
            String isbn,
            int quantidadeTotal,
            int quantidadeDisponivel) {

        int id = gerarProximoIdLivro(livros);
        Livro livro = new Livro(
                id,
                titulo,
                autor,
                anoLancamento,
                categoria,
                isbn,
                quantidadeTotal,
                quantidadeDisponivel);

        verificacoesNecessariasLivro(livro, id, titulo, isbn);

        livros.add(livro);
        livroRepository.salvarLivros(livros);

        System.out.println("Livro cadastrado com sucesso!");
    }

    public void salvarLivros() {
        livroRepository.salvarLivros(livros);
    }

    private void verificacoesNecessariasLivro(Livro livro, int id, String titulo, String isbn) {
        validarLivro.validarLivro(livro);
        validarIdDuplicado(id);
        validarLivroDuplicado(titulo, isbn);
    }

    public void listarLivros() {

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado!");
            return;
        }

        System.out.println("Listando todos os livros.");
        for (Livro livro : livros) {
            System.out.println("-------------------");
            System.out.println(livro);
            System.out.println("-------------------");
            System.out.println();
        }
    }

    public void listarLivrosDisponiveis() {
        System.out.println("Listando todos os livros disponíveis.");
        boolean encontrou = false;

        for (Livro livro : livros) {
            if (livro.getQuantidadeDisponivel() > 0) {
                System.out.println("-------------------");
                System.out.println(livro);
                System.out.println("-------------------");
                System.out.println();
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum livro disponível!");
        }
    }

    public Livro buscarLivroPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }

        throw new LivroNaoEncontradoException("Nenhum livro encontrado com o ID " + id);
    }

    public void buscarLivroPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("-------------------");
                System.out.println(livro);
                System.out.println("-------------------");
                System.out.println();
                return;
            }
        }

        throw new LivroNaoEncontradoException("Nenhum livro encontrado com o título informado");
    }

    public void validarIdDuplicado(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                throw new ValidacaoException("Já existe um livro cadastrado com o ID " + id);
            }
        }
    }

    public void validarLivroDuplicado(String titulo, String isbn) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo) || livro.getIsbn().equals(isbn)) {
                throw new ValidacaoException("Já existe um livro com essas informações");
            }
        }
    }

    public void atualizarQuantidadeDisponivel(int id, int quantidadeDisponivel) {
        Livro livro = buscarLivroPorId(id);
        livro.setQuantidadeDisponivel(quantidadeDisponivel);
        livroRepository.salvarLivros(livros);
    }

    // gets
    public ArrayList<Livro> getLivros() {
        return livros;
    }

}
