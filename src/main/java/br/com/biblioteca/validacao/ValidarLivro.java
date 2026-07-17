package br.com.biblioteca.validacao;

import br.com.biblioteca.exception.ValidacaoException;
import br.com.biblioteca.model.Livro;

public class ValidarLivro {

    // métodos
    public void validarLivro(Livro livro) {

        // verifica se o título foi informado
        if (livro.getTitulo() == null || livro.getTitulo().trim().isEmpty()) {
            throw new ValidacaoException("O título é obrigatório.");
        }

        // verifica se o autor foi informado
        if (livro.getAutor() == null || livro.getAutor().trim().isEmpty()) {
            throw new ValidacaoException("O autor é obrigatório.");
        }

        // verifica se o ano de lançamento tem 4 dígitos
        if (String.valueOf(livro.getAnoLancamento()).length() != 4) {
            throw new ValidacaoException("O ano deve ter 4 dígitos");
        }

        // verifica se a quantidade total não é negativa
        if (livro.getQuantidadeTotal() < 0) {
            throw new ValidacaoException("Quantidade total inválida.");
        }

        // verifica se a quantidade disponivel nao e negativa nem maior que a total
        if (livro.getQuantidadeDisponivel() < 0 || livro.getQuantidadeDisponivel() > livro.getQuantidadeTotal()) {
            throw new ValidacaoException("Quantidade disponível inválida.");
        }
    }
}
