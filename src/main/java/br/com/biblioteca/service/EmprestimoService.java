package main.java.br.com.biblioteca.service;

import main.java.br.com.biblioteca.enums.StatusEmprestimo;
import main.java.br.com.biblioteca.model.Emprestimo;
import main.java.br.com.biblioteca.validacao.ValidarEmprestimo;

import java.time.LocalDate;
import java.util.ArrayList;

public class EmprestimoService {

    // atributos
    private repository.ArquivoRepository repository = new repository.ArquivoRepository();
    private ArrayList<Emprestimo> emprestimo = new ArrayList<>();
    private ValidarEmprestimo validarEmprestimo = new ValidarEmprestimo();
    LocalDate hoje = LocalDate.now();
    LocalDate PrevisaoDevolicao = hoje.plusDays(7);

    // metodos
    public void cadastrarEmprestimo(int id,
                                    int idUsuario,
                                    int idLivro) {

        LocalDate dataEmprestimo = hoje;
        LocalDate dataPrevistaDevolucao = PrevisaoDevolicao;
        LocalDate dataDevolucao = null;
        StatusEmprestimo statusEmprestimo = StatusEmprestimo.ATIVO;

        Emprestimo emprestimo = new Emprestimo(id,
                idUsuario,
                idLivro,
                dataEmprestimo,
                dataPrevistaDevolucao,
                dataDevolucao,
                statusEmprestimo);

        validacoesEmprestimos(id);
        this.emprestimo.add(emprestimo);
        repository.salvarEmprestimos(this.emprestimo);
        System.out.println("Emprestimo cadastrado com sucesso!");
    }

    public Emprestimo buscarEmprestimoPorId(int id) {
        for (Emprestimo emprestimo : emprestimo) {
            if (emprestimo.getId() == id) {
                return emprestimo;
            }
        }
        System.out.println("Nenhum emprÃ©stimo encontrado");
        return null;
    }

    public void listarEmprestimo() {
        if (emprestimo.isEmpty()) {
            System.out.println("Nenhum emprestimo cadastrado!");
            return;
        }

        for (Emprestimo emprestimo : this.emprestimo) {

            System.out.println("-------------------");
            System.out.println(emprestimo);
            System.out.println("-------------------");
        }
    }

    public void listarEmprestimosAtivos(StatusEmprestimo statusEmprestimo) {
        if (emprestimo.isEmpty()) {
            System.out.println("Nenhum emprestimo cadastrado!");
            return;
        }

        for (Emprestimo emprestimo : this.emprestimo) {
            if (statusEmprestimo == StatusEmprestimo.ATIVO)
                System.out.println("-------------------");
            System.out.println(emprestimo);
            System.out.println("-------------------");
        }
    }

    public void listarEmprestimosPorUsuario(int idUsuario) {
        for (Emprestimo emprestimo : this.emprestimo) {
            if (emprestimo.getIdUsuario() == idUsuario)
                System.out.println("-------------------");
            System.out.println(emprestimo);
            System.out.println("-------------------");
        }
    }

    public void adicionarDataDevolucao(int id, LocalDate dataDevolucao) {
        Emprestimo emprestimoEncontrado = buscarEmprestimoPorId(id);
        emprestimoEncontrado.setDataDevolucao(dataDevolucao);
    }

    public void validacoesEmprestimos(int id) {
        validarEmprestimo.verificarLimite();
        validarEmprestimo.descontarEmprestimo(id);
    }
}
