package main.java.br.com.biblioteca.Menu;

import main.java.br.com.biblioteca.model.*;
import main.java.br.com.biblioteca.service.*;
import main.java.br.com.biblioteca.util.DataUtil;
import main.java.br.com.biblioteca.validacao.*;

public class MenuAdmin {

    // atributos
    private LivroService LivroService;
    private EmprestimoService EmprestimoService;
    private UsuarioService ServiceUsuario;
    private model.Livro Livro;

    // metodos
    public void iniciar() {

        // servicos e utilitarios
        UsuarioService usuarioService = new UsuarioService();
        ValidarUsuario validarUsuario = new ValidarUsuario();
        LivroService livroService = new LivroService();
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
        String titulo;
        String autor;
        int anoLancamento;
        enums.CategoriaLivro categoria;
        String isbn;
        int quantidadeTotal;
        int quantidadeDisponivel;

        // menu
        System.out.println("============= ADMIN =============");
        System.out.println("1 - Cadastrar livro");
        System.out.println("2 - Listar livros");
        System.out.println("3 - Cadastrar usuÃ¡rio");
        System.out.println("4 - Listar usuÃ¡rios");
        System.out.println("5 - Listar emprÃ©stimos");
        System.out.println("6 - Ver histÃ³rico");
        System.out.println("0 - Voltar/Sair");
        System.out.println("=================================");
        opcao = entrada.LerOpcao();

        // opcoes
        switch (opcao) {
            case 1:
                while (loop = false) {
                    System.out.println("============= CADASTRAR LIVRO =============");
                    System.out.println("Digite o ID do livro: ");
                    id = entrada.LerId();
                    System.out.println("Digite o tÃ­tulo do livro: ");
                    nome = entrada.LerTitulo();
                    System.out.println("Digite o autor do livro: ");
                    cpf = entrada.LerAutor();
                    System.out.println("Digite o ano de lanÃ§amento do livro: ");
                    anoLancamento = entrada.LerAnoLancamento();
                    System.out.println("Digite a categoria do livro: ");
                    categoria = enums.CategoriaLivro.valueOf(entrada.LerCategoriaLivro().toUpperCase());
                    System.out.println("Digite o ISBN do livro: ");
                    isbn = entrada.LerIsbn();
                    System.out.println("Digite a quantidade total do livro: ");
                    quantidadeTotal = entrada.LerQuantidadeTotal();
                    System.out.println("Digite a quantidade disponÃ­vel do livro: ");
                    quantidadeDisponivel = entrada.LerQuantidadeDisponivel();

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
