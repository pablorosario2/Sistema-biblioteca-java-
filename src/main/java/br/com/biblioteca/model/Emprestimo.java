package main.java.br.com.biblioteca.model;

import main.java.br.com.biblioteca.enums.StatusEmprestimo;

import java.time.LocalDate;

public class Emprestimo {
    private int id;
    private int idUsuario;
    private int idLivro;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao;
    private StatusEmprestimo statusEmprestimo;

    public Emprestimo() {
    }

    public Emprestimo(int id,
            int idUsuario,
            int idLivro,
                      LocalDate dataEmprestimo,
                      LocalDate dataPrevistaDevolucao,
                      LocalDate dataDevolucao,
            StatusEmprestimo statusEmprestimo) {

        this.id = id;
        this.idUsuario = idUsuario;
        this.idLivro = idLivro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.dataDevolucao = dataDevolucao;
        this.statusEmprestimo = statusEmprestimo;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public StatusEmprestimo getStatusEmprestimo() {
        return statusEmprestimo;
    }

    public void setStatusEmprestimo(StatusEmprestimo statusEmprestimo) {
        this.statusEmprestimo = statusEmprestimo;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                ", idLivro=" + idLivro +
                ", dataEmprestimo='" + dataEmprestimo + '\'' +
                ", dataPrevistaDevolucao='" + dataPrevistaDevolucao + '\'' +
                ", dataDevolucao='" + dataDevolucao + '\'' +
                ", statusEmprestimo=" + statusEmprestimo +
                '}';
    }
}
