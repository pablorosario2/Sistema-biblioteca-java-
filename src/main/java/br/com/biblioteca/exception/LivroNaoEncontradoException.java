package br.com.biblioteca.exception;

public class LivroNaoEncontradoException extends br.com.biblioteca.exception.BibliotecaException {

    public LivroNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
