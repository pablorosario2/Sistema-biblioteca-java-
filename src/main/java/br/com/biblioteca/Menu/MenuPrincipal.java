package main.java.br.com.biblioteca.Menu;

import java.util.Scanner;

import main.java.br.com.biblioteca.service.*;
import main.java.br.com.biblioteca.validacao.*;


public class MenuPrincipal {
    private LivroService LivroService;
    private model.Livro Livro;

    public void iniciar() {
        UsuarioService usuarioService = new UsuarioService();
        ValidarUsuario validarUsuario = new ValidarUsuario();
        Scanner print = new Scanner(System.in);

        int opcao;
        int id;
        String nome;
        String cpf;
        String login;
        String senha;
        boolean loop;


        System.out.println("============= biblioteca =============");
        System.out.println("1 - Login");
        System.out.println("2 - Cadastrar usuário");
        System.out.println("3 - Listar livros disponíveis");
        System.out.println("0 - Sair");
        System.out.println("=======================================");
        opcao = print.nextInt();

        switch (opcao) {
            case 1:
                while (loop = false) {

                    print.nextLine();
                    System.out.println("=========== LOGIN ===========");
                    System.out.print("Digite seu login: ");
                    login = print.next();
                    System.out.print("\nDigite a sua senha: ");
                    senha = print.next();

                    if (validarUsuario.validarLogin(login, senha)) {
                        System.out.println("Login realizado com sucesso!");
                        loop = true;
                    } else {
                        System.out.println("Login ou senha inválidos!");
                        loop = false;
                    }
                    break;
                }

            case 2:
                while (loop = false) {
                    print.nextLine();

                    System.out.println("=========== CADASTRAR USUÁRIO ===========");
                    System.out.print("Nome: ");
                    nome = print.nextLine();
                    System.out.print("\nCPF: ");
                    cpf = print.nextLine();
                    System.out.print("\nDigite seu login: ");
                    login = print.next();
                    System.out.print("\nDigite a sua senha: ");
                    senha = print.next();
                    System.out.print("\nTipo de usuário: \n1 - Usuário\n2 - Admin: ");
                    int tipoUsuario = print.nextInt();

                    if (tipoUsuario == 1) {
                        usuarioService.cadastrarUsuario(1, nome, cpf, login, senha, enums.TipoUsuario.USER, 3);
                        loop = true;
                        break;
                    } else if (tipoUsuario == 2) {
                        usuarioService.cadastrarAdmin(1, nome, cpf, login, senha, enums.TipoUsuario.ADMIN);
                        loop = true;
                        break;
                    } else {
                        System.out.println("Opção inválida!");
                        loop = false;
                    }

                }
                break;
            case 3:
                for (model.Livro livro : LivroService.getLivros()) {
                    if (Livro.getQuantidadeDisponivel() > 0) {
                        Livro.MostrarLivro();
                    }
                }
                break;

            case 0:
                break;
        }

    }
}
