package main.java.br.com.biblioteca.validacao;

import enums.TipoUsuario;

public class ValidarUsuario {
    private service.UsuarioService usuarioService;

    public void validarLogin(String login, String senha) {
        for (model.Usuario usuario : usuarioService.getUsuarios()) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha) ) {
                System.out.println("Usuario ja existe");
                System.out.println("-------------------");
                System.out.println(usuario);
                System.out.println("-------------------");
                throw new IllegalArgumentException("");
            } else {
            }
        }
    }

    public void validarLoginDuplicado(String login) {
        for (model.Usuario usuario : usuarioService.getUsuarios()) {
            if (usuario.getLogin().equals(login) ) {
                System.out.println("Esse login ja existe");
                System.out.println("-------------------");
                System.out.println(usuario);
                System.out.println("-------------------");
                throw new IllegalArgumentException("");
            } else {
            }
        }
    }

    public void validarCpfDuplicado(String cpf) {
        for (model.Usuario usuario : usuarioService.getUsuarios()) {
            if (usuario.getCpf() == cpf) {
                System.out.println("-------------------");
                System.out.println(usuario);
                System.out.println("-------------------");
                return;
            } else {
                System.out.println("Nenhum usuario encontrado");
            }
        }
    }

    public void verificarTipoUsuario(enums.TipoUsuario tipoUsuario){
        tipoUsuario = TipoUsuario.USER;
    }


}
