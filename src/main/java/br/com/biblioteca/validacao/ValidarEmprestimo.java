package br.com.biblioteca.validacao;

import br.com.biblioteca.exception.EmprestimoInvalidoException;
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.model.Usuario;

public class ValidarEmprestimo {

    // atributos
    // métodos
    public void descontarEmprestimo(Usuario usuario, Livro livro) {
        verificarLimite(usuario);
        verificarLivroDisponivel(livro);

        usuario.setLimiteEmprestimo(usuario.getLimiteEmprestimo() - 1);
        livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() - 1);
    }

    public void verificarLimite(Usuario usuario) {
        if (usuario.getLimiteEmprestimo() <= 0) {
            throw new EmprestimoInvalidoException("Usuário não tem mais empréstimo disponível");
        }
    }

    public void verificarLivroDisponivel(Livro livro) {
        if (livro.getQuantidadeDisponivel() <= 0) {
            throw new EmprestimoInvalidoException("Livro indisponível para empréstimo");
        }
    }

}
