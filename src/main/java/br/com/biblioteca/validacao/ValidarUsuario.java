package br.com.biblioteca.validacao;

import br.com.biblioteca.enums.TipoUsuario;
import br.com.biblioteca.exception.ValidacaoException;
import br.com.biblioteca.model.Usuario;

import java.util.List;

public class ValidarUsuario {

    // métodos
    public void validarNome(String nome) {
        if (nome.isEmpty()) {
            throw new ValidacaoException("Nome não pode estar vazio");
        }
    }

    public Usuario validarLogin(String login, String senha, List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }

        return null;
    }

    public void validarLoginDuplicado(String login, List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                System.out.println("Esse login já existe");
                throw new ValidacaoException("Esse login já existe");
            }
        }
    }

    public void validarCpfDuplicado(String cpf, List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                throw new ValidacaoException("Esse CPF já existe");
            }
        }
    }

    public void verificarTipoUsuario(TipoUsuario tipoUsuario) {
        if (tipoUsuario != TipoUsuario.USER && tipoUsuario != TipoUsuario.ADMIN) {
            throw new ValidacaoException("Tipo de usuário somente USUÁRIO / ADMIN");
        }
    }
}
