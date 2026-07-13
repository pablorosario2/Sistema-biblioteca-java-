package main.java.br.com.biblioteca.validacao;

import main.java.br.com.biblioteca.model.Emprestimo;

public class ValidarEmprestimo {
    private model.Usuario usuario;
    private model.Livro livro;

    public void validarEmprestimo(Emprestimo emprestimo) {

        if (usuario.getLimiteEmprestimo() <= 0) {
            throw new IllegalArgumentException("Usuario não tem mais emprestimo disponivel");
        } else if (usuario.getLimiteEmprestimo() >= 0) {
            int limiteemprestimo = usuario.getLimiteEmprestimo();
            usuario.setLimiteEmprestimo(limiteemprestimo - 1);
        }
    }
}
