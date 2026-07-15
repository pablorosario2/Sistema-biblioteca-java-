package main.java.br.com.biblioteca.Menu;

import main.java.br.com.biblioteca.service.*;
import main.java.br.com.biblioteca.util.DataUtil;
import main.java.br.com.biblioteca.validacao.*;

public class MenuPrincipal {

    // atributos
    private LivroService LivroService;
    private model.Livro Livro;

    // metodos
    public void iniciar() {

        // servicos e utilitarios
        UsuarioService usuarioService = new UsuarioService();
        ValidarUsuario validarUsuario = new ValidarUsuario();
        EmprestimoService emprestimoService = new EmprestimoService();
        util.Entrada entrada = new util.Entrada();
        DataUtil data = new DataUtil();

        // variaveis locais
        int opcao;
        int id;
        String nome;
        String cpf;
        String login;
        String senha;
        boolean loop;

        // menu
        System.out.println("============= biblioteca =============");
        System.out.println("1 - Login");
        System.out.println("2 - Cadastrar usuÃ¡rio");
        System.out.println("3 - Listar livros disponÃ­veis");
        System.out.println("0 - Sair");
        System.out.println("=======================================");
        opcao = entrada.LerOpcao();

        // opcoes
        switch (opcao) {
            case 1:
                while (loop = false) {

                    System.out.println("=========== LOGIN ===========");
                    System.out.print("Digite seu login: ");
                    login = entrada.LerLogin();
                    System.out.print("\nDigite a sua senha: ");
                    senha = entrada.LerSenha();

                    if (validarUsuario.validarLogin(login, senha)) {
                        System.out.println("Login realizado com sucesso!");
                        loop = true;
                    } else {
                        System.out.println("Login ou senha invÃ¡lidos!");
                        loop = false;
                    }
                    break;
                }

            case 2:
                while (loop = false) {
                    System.out.println("=========== CADASTRAR USUÃRIO ===========");
                    System.out.print("Nome: ");
                    nome = entrada.LerNome();
                    System.out.print("\nCPF: ");
                    cpf = entrada.LerCpf();
                    System.out.print("\nDigite seu login: ");
                    login = entrada.LerLogin();
                    System.out.print("\nDigite a sua senha: ");
                    senha = entrada.LerSenha();
                    System.out.print("\nTipo de usuÃ¡rio: \n1 - UsuÃ¡rio\n2 - Admin: ");
                    int tipoUsuario = entrada.LerTipoUsuario();

                    if (tipoUsuario == 1) {
                        usuarioService.cadastrarUsuario(1, nome, cpf, login, senha, enums.TipoUsuario.USER, 3);
                        loop = true;
                        break;
                    } else if (tipoUsuario == 2) {
                        usuarioService.cadastrarAdmin(1, nome, cpf, login, senha, enums.TipoUsuario.ADMIN);
                        loop = true;
                        break;
                    } else {
                        System.out.println("OpÃ§Ã£o invÃ¡lida!");
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
