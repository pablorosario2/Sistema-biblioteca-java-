package model;

import enums.TipoUsuario;

public class Usuario {
    private int id;
    private String nome;
    private String cpf;
    private String login;
    private String senha;
    private TipoUsuario tipoUsuario;
    private int limiteEmprestimo;

    public Usuario() {
    }

    public Usuario(
            int id,
            String nome,
            String cpf,
            String login,
            String senha,
            TipoUsuario tipoUsuario,
            int limiteEmprestimo,
            enums.TipoUsuario user) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.limiteEmprestimo = limiteEmprestimo;
    }

    public void mostrarUsuario() {
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Login: " + this.login);
        System.out.println("Tipo de Usuario: " + this.tipoUsuario);
        System.out.println("Limite de Emprestimo: " + this.limiteEmprestimo);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getLimiteEmprestimo() {
        return limiteEmprestimo;
    }

    public void setLimiteEmprestimo(int limiteEmprestimo) {
        this.limiteEmprestimo = limiteEmprestimo;
    }

}
