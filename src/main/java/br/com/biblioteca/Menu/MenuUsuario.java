package main.java.br.com.biblioteca.Menu;

import main.java.br.com.biblioteca.enums.StatusEmprestimo;
import main.java.br.com.biblioteca.service.EmprestimoService;
import main.java.br.com.biblioteca.service.LivroService;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuUsuario {
    private LivroService LivroService;


    public static void iniciar() {
        LocalDate hoje = LocalDate.now();
        LivroService livroService = new LivroService();
        EmprestimoService emprestimoService = new EmprestimoService();

        int opcao;
        int id;
        int idUsuario;
        int idLivro;
        String dataEmprestimo;
        String dataPrevistaDevolucao;
        String dataDevolucao;
        StatusEmprestimo statusEmprestimo;
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
        Scanner print = new Scanner(System.in);


        System.out.println("============= USER =============");
        System.out.println("1 - Listar livros disponíveis");
        System.out.println("2 - Buscar livro por título");
        System.out.println("3 - Pegar livro emprestado");
        System.out.println("4 - Devolver livro");
        System.out.println("5 - Ver meus empréstimos");
        System.out.println("0 - Voltar/Sair");
        System.out.println("=================================");
        opcao = print.nextInt();

        switch (opcao) {
            case 1:
                livroService.listarLivrosDisponiveis();

            case 2:
                System.out.println("Qual o ID do livro?");
                id = print.nextInt();
                livroService.buscarLivroPorId(id);

            case 3:
                System.out.println("========== PEGAR LIVRO ==========");
                System.out.println("ID do emprestimo: ");
                id = print.nextInt();
                System.out.println("ID do usuario: ");
                idUsuario = print.nextInt();
                System.out.println("ID do livro: ");
                idLivro = print.nextInt();
                emprestimoService.cadastrarEmprestimo(id, idUsuario, idLivro);

            case 4:
                System.out.println("========== DEVOLVER LIVRO ==========");
                System.out.println("ID do emprestimo: ");
                id = print.nextInt();
                emprestimoService.adicionarDataDevolucao(id, hoje);

            case 5:
                System.out.println("========== Ver meus empréstimos ==========");
                System.out.println("ID do usuario: ");
                EmprestimoService.listarEmprestimosPorUsuario();
        }


    }
}
