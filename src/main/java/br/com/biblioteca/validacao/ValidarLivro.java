package main.java.br.com.biblioteca.validacao;

import main.java.br.com.biblioteca.model.Livro;

public class ValidarLivro {
    public void validarLivro(Livro livro) {

        ;
        ;

        if (livro.getTitulo() == null || livro.getTitulo().trim().isEmpty()) {
            throw new IllegalArgumentException("O título é obrigatório.");
        }

        if (livro.getAutor() == null || livro.getAutor().trim().isEmpty()) {
            throw new IllegalArgumentException("O autor é obrigatório.");
        }

        if (livro.getQuantidadeTotal() <= 0) {
            throw new IllegalArgumentException("Quantidade total inválida.");
        }

        if (livro.getQuantidadeDisponivel() < 0 || livro.getQuantidadeDisponivel() < livro.getQuantidadeTotal()) {
            throw new IllegalArgumentException("Quantidade disponível inválida.");
        }
    }
}
