package main.java.br.com.biblioteca.service;

import main.java.br.com.biblioteca.enums.StatusEmprestimo;
import main.java.br.com.biblioteca.model.Emprestimo;
import main.java.br.com.biblioteca.util.DataUtil;
import main.java.br.com.biblioteca.validacao.ValidarEmprestimo;
import main.java.br.com.biblioteca.repository.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class EmprestimoService {

    // atributos
    private ValidarEmprestimo validarEmprestimo = new ValidarEmprestimo();
    private repositoryEmprestimo repositoryEmprestimo = new repositoryEmprestimo();
    private ArrayList<Emprestimo> emprestimos = repositoryEmprestimo.carregarEmprestimos();
    private DataUtil data = new DataUtil();

    // metodos
    public void cadastrarEmprestimo(int id,
                                    int idUsuario,
                                    int idLivro) {

        LocalDate dataEmprestimo = data.hoje();
        LocalDate dataPrevistaDevolucao = data.PrevisaoDevolicao(data.hoje());
        LocalDate dataDevolucao = null;
        StatusEmprestimo statusEmprestimo = StatusEmprestimo.ATIVO;

        Emprestimo Emprestimo = new Emprestimo(id,
                idUsuario,
                idLivro,
                dataEmprestimo,
                dataPrevistaDevolucao,
                dataDevolucao,
                statusEmprestimo);

        validacoesEmprestimos(id);
        emprestimos.add(Emprestimo);
        repositoryEmprestimo.salvarEmprestimos(emprestimos);
        System.out.println("Emprestimo cadastrado com sucesso!");
    }

    public void validacoesEmprestimos(int id) {
        validarEmprestimo.verificarLimite();
        validarEmprestimo.descontarEmprestimo(id);
    }

    public Emprestimo buscarEmprestimoPorId(int id) {
        for (Emprestimo Emprestimo : emprestimos) {
            if (Emprestimo.getId() == id) {
                return Emprestimo;
            }
        }
        System.out.println("Nenhum emprestimo encontrado");
        return null;
    }

    public void listarEmprestimo() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum emprestimo cadastrado!");
            return;
        }

        for (Emprestimo Emprestimo : this.emprestimos) {

            System.out.println(Emprestimo);
        }
    }

    public void listarEmprestimosAtivos(StatusEmprestimo statusEmprestimo) {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum emprestimo cadastrado!");
            return;
        }

        for (Emprestimo emprestimo : this.emprestimos) {
            if (statusEmprestimo == StatusEmprestimo.ATIVO)
            System.out.println(emprestimo);
        }
    }

    public void listarEmprestimosPorUsuario(int idUsuario) {
        for (Emprestimo Emprestimo : this.emprestimos) {
            if (Emprestimo.getIdUsuario() == idUsuario)
            System.out.println(Emprestimo);
            break;
        }
    }

    public void adicionarDataDevolucao(int id, String dataDevolucao) {
        LocalDate dataFormatada = data.converterStringData(dataDevolucao);
        Emprestimo emprestimoEncontrado = buscarEmprestimoPorId(id);
        emprestimoEncontrado.setDataDevolucao(dataFormatada);
    }


}
