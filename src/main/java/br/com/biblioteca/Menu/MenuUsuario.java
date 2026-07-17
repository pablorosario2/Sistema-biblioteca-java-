package br.com.biblioteca.menu;

import br.com.biblioteca.exception.BibliotecaException;
import br.com.biblioteca.service.EmprestimoService;
import br.com.biblioteca.service.LivroService;
import br.com.biblioteca.util.DataUtil;
import br.com.biblioteca.model.Usuario;
import br.com.biblioteca.util.Entrada;

public class MenuUsuario {

    // métodos
    public void iniciar(Usuario usuario) {

        // serviços e utilitários
        Entrada entrada = new Entrada();

        // Mantem o menu do usuario aberto ate escolher voltar.
        while (true) {
            // menu
            System.out.println();
            System.out.println("============= USUÁRIO =============");
            System.out.println("1 - Listar livros disponíveis");
            System.out.println("2 - Buscar livro por título");
            System.out.println("3 - Pegar livro emprestado");
            System.out.println("4 - Devolver livro");
            System.out.println("5 - Ver meus empréstimos");
            System.out.println("0 - Voltar/Sair");
            System.out.println("=================================");
            int opcao = entrada.lerOpcao();

            // opções
            switch (opcao) {
                case 1:
                    try {
                        LivroService livroService = new LivroService();
                        livroService.listarLivrosDisponiveis();
                    } catch (BibliotecaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Qual é o título do livro?");
                    String titulo = entrada.lerTitulo();
                    try {
                        LivroService livroService = new LivroService();
                        livroService.buscarLivroPorTitulo(titulo);
                    } catch (BibliotecaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("========== PEGAR LIVRO ==========");
                    System.out.println("ID do livro: ");
                    int idLivro = entrada.lerId();

                    try {
                        EmprestimoService emprestimoService = new EmprestimoService();
                        emprestimoService.cadastrarEmprestimo(usuario.getId(), idLivro);
                    } catch (BibliotecaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("========== DEVOLVER LIVRO ==========");
                    System.out.println("ID do empréstimo: ");
                    int id = entrada.lerId();
                    DataUtil data = new DataUtil();
                    try {
                        EmprestimoService emprestimoService = new EmprestimoService();
                        emprestimoService.adicionarDataDevolucao(id, data.hoje());
                    } catch (BibliotecaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("========== VER MEUS EMPRÉSTIMOS ==========");
                    try {
                        EmprestimoService emprestimoService = new EmprestimoService();
                        emprestimoService.listarEmprestimosPorUsuario(usuario.getId());
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
