package main.java.br.com.biblioteca.service;

import main.java.br.com.biblioteca.enums.StatusEmprestimo;
import main.java.br.com.biblioteca.model.Emprestimo;
import main.java.br.com.biblioteca.validacao.ValidarEmprestimo;

import java.util.ArrayList;

public class EmprestimoService {
    private repository.ArquivoRepository repository = new repository.ArquivoRepository();
    private ArrayList<Emprestimo> Emprestimo = new ArrayList<>();
    private ValidarEmprestimo validarEmprestimo = new ValidarEmprestimo();

    public void cadastrarEmprestimo(int id,
                                    int idUsuario,
                                    int idLivro,
                                    String dataEmprestimo,
                                    String dataPrevistaDevolucao,
                                    String dataDevolucao,
                                    StatusEmprestimo statusEmprestimo) {

        Emprestimo emprestimo = new Emprestimo(id,
                idUsuario,
                idLivro,
                dataEmprestimo,
                dataPrevistaDevolucao,
                dataDevolucao,
                statusEmprestimo);

        Emprestimo.add(emprestimo);
        repository.salvarEmprestimos(Emprestimo);
        System.out.println("Emprestimo cadastrado com sucesso!");

    }

    public void listarEmprestimo() {
        if (Emprestimo.isEmpty()) {
            System.out.println("Nenhum emprestimo cadastrado!");
            return;
        }

        for (Emprestimo emprestimo : Emprestimo) {

            System.out.println("-------------------");
            System.out.println(Emprestimo);
            System.out.println("-------------------");
        }
    }


    public void listarEmprestimosAtivos(StatusEmprestimo statusEmprestimo) {
        if (Emprestimo.isEmpty()) {
            System.out.println("Nenhum emprestimo cadastrado!");
            return;
        }

        for (Emprestimo emprestimo : Emprestimo) {
            if (statusEmprestimo == StatusEmprestimo.ATIVO)
            System.out.println("-------------------");
            System.out.println(Emprestimo);
            System.out.println("-------------------");
        }
    }

    public void listarEmprestimosPorUsuario(int idUsuario) {
        for (Emprestimo emprestimo : Emprestimo) {
            if (emprestimo.getIdUsuario() == idUsuario)
                System.out.println("-------------------");
            System.out.println(Emprestimo);
            System.out.println("-------------------");
        }
    }

}




