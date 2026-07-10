package model;

public class Admin extends Usuario {
    public Admin(
            int id,
            String nome,
            String cpf,
            String login,
            String senha,
            TipoUsuario tipoUsuario) {
        super(
                id,
                nome,
                cpf,
                login,
                senha,
                enums.TipoUsuario admin);
    }

}
