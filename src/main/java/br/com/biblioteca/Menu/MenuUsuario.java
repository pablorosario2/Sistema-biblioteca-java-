package main.java.br.com.biblioteca.Menu;

import jdk.jshell.execution.Util;
import main.java.br.com.biblioteca.enums.StatusEmprestimo;
import main.java.br.com.biblioteca.service.EmprestimoService;
import main.java.br.com.biblioteca.service.LivroService;

import main.java.br.com.biblioteca.util.*;

public class MenuUsuario {

    // metodos
    public static void iniciar() {

        // servicos e utilitarios
        LivroService livroService = new LivroService();
        EmprestimoService emprestimoService = new EmprestimoService();
        util.Entrada entrada = new util.Entrada();
        DataUtil data = new DataUtil();

        // variaveis locais
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

        // menu
        System.out.println("============= USER =============");
        System.out.println("1 - Listar livros disponÃ­veis");
        System.out.println("2 - Buscar livro por tÃ­tulo");
        System.out.println("3 - Pegar livro emprestado");
        System.out.println("4 - Devolver livro");
        System.out.println("5 - Ver meus emprÃ©stimos");
        System.out.println("0 - Voltar/Sair");
        System.out.println("=================================");
        opcao = entrada.LerOpcao();

        // opcoes
        switch (opcao) {
            case 1:
                livroService.listarLivrosDisponiveis();
                break;

            case 2:
                System.out.println("Qual o ID do livro?");
                id = entrada.LerId();
                livroService.buscarLivroPorId(id);
                break;

            case 3:
                System.out.println("========== PEGAR LIVRO ==========");
                System.out.println("ID do emprestimo: ");
                id = entrada.LerId();
                System.out.println("ID do usuario: ");
                idUsuario = entrada.LerId();
                System.out.println("ID do livro: ");
                idLivro = entrada.LerId();
                emprestimoService.cadastrarEmprestimo(id, idUsuario, idLivro);
                break;

            case 4:
                System.out.println("========== DEVOLVER LIVRO ==========");
                System.out.println("ID do emprestimo: ");
                id = entrada.LerId();
                emprestimoService.adicionarDataDevolucao(id, data.hoje());
                break;

            case 5:
                System.out.println("========== Ver meus emprÃ©stimos ==========");
                System.out.println("ID do usuario: ");
                id = entrada.LerId();
                emprestimoService.listarEmprestimosPorUsuario(id);
                break;

            case 6:
                return;
        }

    }
}
