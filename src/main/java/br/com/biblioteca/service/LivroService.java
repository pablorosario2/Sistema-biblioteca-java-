package main.java.br.com.biblioteca.service;

import main.java.br.com.biblioteca.model.Livro;
import main.java.br.com.biblioteca.validacao.ValidarLivro;

import java.util.ArrayList;

public class LivroService {
    private ArrayList<Livro> livros = new ArrayList<>();
    ValidarLivro validador = new ValidarLivro();

    public void cadastrarLivro(int id, String titulo, String autor, int anoLancamento, String isbn, int quantidadeTotal, int quantidadeDisponivel) {

        Livro livro = new Livro(id, titulo, autor, anoLancamento, isbn, quantidadeTotal, quantidadeDisponivel);


        validador.validarLivro(livro);

        livros.add(livro);

        System.out.println("Livro cadastrado com sucesso!");
    }
}


public void listarLivros() {
    System.out.println("Listando todos os livros.");
    System.out.println(toString(livros));
}

void listarLivrosDisponiveis() {

}

void buscarLivroPorId() {

}

void buscarLivroPorTitulo() {

}

void validarLivroDuplicado() {

}

void atualizarQuantidadeDisponivel() {

}


}
