package br.com.biblioteca.menu;

import br.com.biblioteca.enums.CategoriaLivro;
import br.com.biblioteca.enums.TipoUsuario;
import br.com.biblioteca.exception.BibliotecaException;
import br.com.biblioteca.service.EmprestimoService;
import br.com.biblioteca.service.LivroService;
import br.com.biblioteca.service.UsuarioService;
import br.com.biblioteca.util.Entrada;

public class MenuAdmin {

    // métodos
    public void iniciar() {

        // serviços e utilitários
        Entrada entrada = new Entrada();

        // Mantem o menu do administrador aberto ate escolher voltar.
        while (true) {
            // menu
            System.out.println();
            System.out.println("============= ADMIN =============");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Cadastrar usuário");
            System.out.println("4 - Listar usuários");
            System.out.println("5 - Listar empréstimos");
            System.out.println("6 - Ver histórico");
            System.out.println("0 - Voltar/Sair");
            System.out.println("=================================");
            int opcao = entrada.lerOpcao();

            // opções
            switch (opcao) {
                case 1:
                    System.out.println("============= CADASTRAR LIVRO =============");
                    System.out.println("Digite o título do livro: ");
                    String titulo = entrada.lerTitulo();

                    System.out.println("Digite o autor do livro: ");
                    String autor = entrada.lerAutor();

                    System.out.println("Digite o ano de lançamento do livro [xxxx]: ");
                    int anoLancamento = entrada.lerAnoLancamento();

                    System.out.println("Categoria do livro: ");
                    System.out.println("[1] -> VERIFICAR AS CATEGORIAS DE LIVROS");
                    System.out.println("[2] -> JÁ SEI AS CATEGORIAS");
                    opcao = entrada.lerOpcao();

                    // Garante que o usuario escolha uma das opcoes de categoria.
                    while (opcao != 1 && opcao != 2) {
                        System.out.println("Opção inválida!");
                        opcao = entrada.lerOpcao();
                    }

                    if (opcao == 1) {
                        for (CategoriaLivro categoriaLivro : CategoriaLivro.values()) {
                            System.out.println(categoriaLivro);
                        }
                    }

                    CategoriaLivro categoria = CategoriaLivro.valueOf(entrada.lerCategoriaLivro().toUpperCase());

                    System.out.println("Digite o ISBN do livro: ");
                    String isbn = entrada.lerIsbn();

                    System.out.println("Digite a quantidade total do livro: ");
                    int quantidadeTotal = entrada.lerQuantidadeTotal();

                    System.out.println("Digite a quantidade disponível do livro: ");
                    int quantidadeDisponivel = entrada.lerQuantidadeDisponivel();

                    try {
                        LivroService livroService = new LivroService();
                        livroService.cadastrarLivro(titulo, autor, anoLancamento, categoria, isbn, quantidadeTotal, quantidadeDisponivel);
                    } catch (BibliotecaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        LivroService livroServiceListagem = new LivroService();
                        livroServiceListagem.listarLivros();
                    } catch (BibliotecaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("=========== CADASTRAR USUÁRIO ===========");
                    System.out.print("Nome: ");
                    String nome = entrada.lerNome();

                    System.out.print("\nCPF: ");
                    String cpf = entrada.lerCpf();

                    System.out.print("\nDigite seu melhor e-mail: ");
                    String email = entrada.lerEmail();

                    System.out.print("\nDigite seu login: ");
                    String login = entrada.lerLogin();

                    System.out.print("\nDigite a sua senha: ");
                    String senha = entrada.lerSenha();

                    System.out.print("\nTipo de usuário: \n1 - Usuário\n2 - Admin: ");
                    int tipoUsuario = entrada.lerTipoUsuario();

                    if (tipoUsuario == 1) {
                        try {
                            UsuarioService usuarioService = new UsuarioService();
                            usuarioService.cadastrarUsuario(nome, cpf, email, login, senha, TipoUsuario.USER);
                        } catch (BibliotecaException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (tipoUsuario == 2) {
                        try {
                            UsuarioService usuarioService = new UsuarioService();
                            usuarioService.cadastrarUsuario(nome, cpf, email, login, senha, TipoUsuario.ADMIN);
                        } catch (BibliotecaException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;

                case 4:
                    try {
                        UsuarioService usuarioServiceListagem = new UsuarioService();
                        usuarioServiceListagem.listarUsuarios();
                    } catch (BibliotecaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        EmprestimoService emprestimoService = new EmprestimoService();
                        emprestimoService.listarEmprestimo();
                    } catch (BibliotecaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Digite o ID do usuário para ver o histórico: ");
                    int idUsuario = entrada.lerId();
                    try {
                        EmprestimoService emprestimoServiceHistorico = new EmprestimoService();
                        emprestimoServiceHistorico.listarHistoricoEmprestimo(idUsuario);
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
