package main.java.br.com.biblioteca.Menu;

import java.util.Scanner;
import main.java.br.com.biblioteca.service.*;
import main.java.br.com.biblioteca.validacao.*;

public class MenuPrincipal {

    public void iniciar() {
        UsuarioService usuarioService = new UsuarioService();
        ValidarUsuario validarUsuario = new ValidarUsuario();
        int opcao;
        String login;
        String senha;

        Scanner print = new Scanner(System.in);
        System.out.println(
                "1 - Login\n" +
                        "2 - Cadastrar usuário\n" +
                        "3 - Listar livros disponíveis\n" +
                        "0 - Sair");
        opcao = print.nextInt();

        switch (opcao) {
            case 1:
                for () {
                    print.nextLine();
                    System.out.println("Digite seu login: ");
                    login = print.next();

                    System.out.println("Digite a sua senha: ");
                    senha = print.next();
                    if (validarUsuario.validarLogin(login, senha)) {

                    }


                }
        }
    }
}
