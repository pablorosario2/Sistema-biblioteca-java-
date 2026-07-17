package br.com.biblioteca.model;

import br.com.biblioteca.enums.TipoUsuario;

public class Admin extends br.com.biblioteca.model.Usuario {

    // construtores
    public Admin(int id,
                 String nome,
                 String cpf,
                 String email,
                 String login,
                 String senha) {
        super(id, nome, cpf, email, login, senha, TipoUsuario.ADMIN, 100);
    }
}
