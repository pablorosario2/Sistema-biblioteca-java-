package main.java.br.com.biblioteca.model;

import main.java.br.com.biblioteca.enums.StatusEmprestimo;

public class Emprestimo {
    private int id;
    private int idUsuario;
    private int idLivro;
    private String dataEmprestimo;
    private String dataPrevistaDevolucao;
    private String dataDevolucao;
    private StatusEmprestimo statusEmprestimo;

    public Emprestimo() {
    }

    public Emprestimo(int id,
            int idUsuario,
            int idLivro,
            String dataEmprestimo,
            String dataPrevistaDevolucao,
            String dataDevolucao,
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

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(String dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
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
