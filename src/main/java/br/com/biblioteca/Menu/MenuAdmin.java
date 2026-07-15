package main.java.br.com.biblioteca.Menu;

import java.util.Scanner;

import main.java.br.com.biblioteca.model.*;
import main.java.br.com.biblioteca.service.*;
import main.java.br.com.biblioteca.validacao.*;

public class MenuAdmin {

    private LivroService LivroService;
    private EmprestimoService EmprestimoService;
    private UsuarioService ServiceUsuario;
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
        String titulo;
        String autor;
        int anoLancamento;
        enums.CategoriaLivro categoria;
        String isbn;
        int quantidadeTotal;
        int quantidadeDisponivel;

        System.out.println("============= ADMIN =============");
        System.out.println("1 - Cadastrar livro");
        System.out.println("2 - Listar livros");
        System.out.println("3 - Cadastrar usuário");
        System.out.println("4 - Listar usuários");
        System.out.println("5 - Listar empréstimos");
        System.out.println("6 - Ver histórico");
        System.out.println("0 - Voltar/Sair");
        System.out.println("=================================");
        opcao = print.nextInt();

        switch (opcao) {
            case 1:
                print.nextLine();
                while (loop = false) {
                    System.out.println("============= CADASTRAR LIVRO =============");
                    System.out.println("Digite o ID do livro: ");
                    id = print.nextInt();
                    System.out.println("Digite o título do livro: ");
                    nome = print.next();
                    System.out.println("Digite o autor do livro: ");
                    cpf = print.next();
                    System.out.println("Digite o ano de lançamento do livro: ");
                    anoLancamento = print.nextInt();
                    System.out.println("Digite a categoria do livro: ");
                    categoria = enums.CategoriaLivro.valueOf(print.next().toUpperCase());
                    System.out.println("Digite o ISBN do livro: ");
                    isbn = print.next();
                    System.out.println("Digite a quantidade total do livro: ");
                    quantidadeTotal = print.nextInt();
                    System.out.println("Digite a quantidade disponível do livro: ");
                    quantidadeDisponivel = print.nextInt();

                    LivroService.cadastrarLivro(id, nome, cpf, anoLancamento, categoria, isbn, quantidadeTotal, quantidadeDisponivel);
                    loop = true;
                    break;
                }

            case 2:
                for (model.Livro livro : LivroService.getLivros()) {
                    Livro.MostrarLivro();
                }
            case 3:
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
            case 4:
                ServiceUsuario.listarUsuarios();
                break;

            case 5:
                EmprestimoService.listarEmprestimo();
                break;
            case 6:

            case 0:
                break;
        }


    }

}
