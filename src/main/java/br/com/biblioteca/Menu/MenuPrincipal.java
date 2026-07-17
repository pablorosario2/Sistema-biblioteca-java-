package br.com.biblioteca.menu;

import br.com.biblioteca.enums.TipoUsuario;
import br.com.biblioteca.exception.BibliotecaException;
import br.com.biblioteca.service.LivroService;
import br.com.biblioteca.service.UsuarioService;
import br.com.biblioteca.util.Entrada;
import br.com.biblioteca.model.Usuario;
import br.com.biblioteca.menu.MenuAdmin;
import br.com.biblioteca.menu.MenuUsuario;

public class MenuPrincipal {

    // métodos
    public void iniciar() {

        // serviços e utilitários
        Entrada entrada = new Entrada();

        // Mantem o menu principal aberto ate o usuario escolher sair.
        while (true) {
            // menu
            System.out.println();
            System.out.println("============= biblioteca =============");
            System.out.println("1 - Login");
            System.out.println("2 - Cadastrar usuário");
            System.out.println("3 - Listar livros disponíveis");
            System.out.println("0 - Sair/Voltar");
            System.out.println("=======================================");
            int opcao = entrada.lerOpcao();

            // opções
            switch (opcao) {
                case 1:
                    System.out.println("=========== LOGIN ===========");
                    System.out.print("Digite seu login: ");
                    String login = entrada.lerLogin();
                    System.out.print("Digite a sua senha: ");
                    String senha = entrada.lerSenha();

                    try {
                        UsuarioService usuarioService = new UsuarioService();
                        Usuario usuarioLogado = usuarioService.validarLogin(login, senha);

                        System.out.println("Login realizado com sucesso!");

                        // Depois do login, cada tipo de usuario vai para o seu menu.
                        if (usuarioLogado.getTipoUsuario() == TipoUsuario.ADMIN) {
                            new MenuAdmin().iniciar();
                        } else if (usuarioLogado.getTipoUsuario() == TipoUsuario.USER) {
                            new MenuUsuario().iniciar(usuarioLogado);
                        }
                    } catch (BibliotecaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("=========== CADASTRAR USUÁRIO ===========");
                    System.out.print("Nome: ");
                    String nome = entrada.lerNome();

                    System.out.print("\nCPF: ");
                    String cpf = entrada.lerCpf();

                    System.out.print("\nDigite seu melhor e-mail: ");
                    String email = entrada.lerEmail();

                    System.out.print("\nDigite seu login: ");
                    login = entrada.lerLogin();

                    System.out.print("\nDigite a sua senha: ");
                    senha = entrada.lerSenha();

                    System.out.print("\nTipo de usuário: \n1 - Usuário\n2 - Admin: ");
                    int tipoUsuario = entrada.lerTipoUsuario();

                    if (tipoUsuario == 1) {
                        try {
                            UsuarioService usuarioServiceCadastro = new UsuarioService();
                            usuarioServiceCadastro.cadastrarUsuario(nome, cpf, email, login, senha, TipoUsuario.USER);
                        } catch (BibliotecaException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (tipoUsuario == 2) {
                        try {
                            UsuarioService usuarioServiceCadastro = new UsuarioService();
                            usuarioServiceCadastro.cadastrarUsuario(nome, cpf, email, login, senha, TipoUsuario.ADMIN);
                        } catch (BibliotecaException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;

                case 3:
                    try {
                        LivroService livroService = new LivroService();
                        livroService.listarLivrosDisponiveis();
                    } catch (BibliotecaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
