package model;

import enums.TipoUsuario;


public class Admin extends model.Usuario {
    public Admin(
            int id,
            String nome,
            String cpf,
            String login,
            String senha) {
        super(
                id,
                nome,
                cpf,
                login,
                senha,
                TipoUsuario.ADMIN);
    }

}
