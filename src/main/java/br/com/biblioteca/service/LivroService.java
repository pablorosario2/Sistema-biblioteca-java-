package main.java.br.com.biblioteca.service;

import model.Livro;
import validacao.ValidarLivro;

import java.util.ArrayList;

import enums.CategoriaLivro;

public class LivroService {

    // atributos
    private repository.ArquivoRepository repository = new repository.ArquivoRepository();
    private ArrayList<Livro> livros = new ArrayList<>();
    private ValidarLivro validarLivro = new ValidarLivro();

    // metodos
    public void cadastrarLivro(int id, String titulo, String autor, int anoLancamento, CategoriaLivro categoria, String isbn, int quantidadeTotal, int quantidadeDisponivel) {

        Livro livro = new Livro(id, titulo, autor, anoLancamento, categoria, isbn, quantidadeTotal, quantidadeDisponivel);

        verificacoesNecessariasLivro(livro, id, titulo, isbn);

        livros.add(livro);
        repository.salvarLivros(livros);

        System.out.println("Livro cadastrado com sucesso!");
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
        }
    }

    public void listarLivrosDisponiveis() {
        System.out.println("Listando todos os livros disponÃ­veis.");

        boolean encontrou = false;

        for (Livro livro : livros) {
            if (livro.getQuantidadeDisponivel() > 0) {
                System.out.println("-------------------");
                System.out.println(livro);
                System.out.println("-------------------");

                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum livro disponÃ­vel!");
        }
    }

    public Livro buscarLivroPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        System.out.println("Nenhum livro encontrado");
        return null;
    }

    public void buscarLivroPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("-------------------");
                System.out.println(livro);
                System.out.println("-------------------");
                return;
            }
        }

    }

    public void validarIdDuplicado(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                throw new IllegalArgumentException("JÃ¡ existe um livro cadastrado com o ID " + id);
            }
        }
    }

    public Livro validarLivroDuplicado(int id, String titulo, String isbn) {
        for (Livro livro : livros) {
            if (livro.getId() == id || livro.getTitulo().equalsIgnoreCase(titulo) || livro.getIsbn().equals(isbn)) {
                System.out.println("Ja existe um livro com essa informaÃ§Ãµes");
                return livro;
            }

        }
        return null;
    }

    public void atualizarQuantidadeDisponivel(int id, int quantidadeDisponivel) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                System.out.println("-------------------");
                System.out.println(livro);
                System.out.println("-------------------");
                livro.setQuantidadeDisponivel(quantidadeDisponivel);
                System.out.println("Quantidade disponivel atualziada: ");
                System.out.println("-------------------");
                System.out.println(livro);
                System.out.println("-------------------");
                return;
            } else {
                System.out.println("Nenhum livro encontrado");
            }
        }

    }

    // gets
    public ArrayList<Livro> getLivros() {
        return livros;
    }

    // metodos privados
    private void verificacoesNecessariasLivro(Livro livro, int id, String titulo, String isbn) {
        validarLivro.validarLivro(livro);
        validarIdDuplicado(id);
        validarLivroDuplicado(id, titulo, isbn);
    }
}
