package br.com.biblioteca.model;

import br.com.biblioteca.enums.TipoUsuario;

public class Usuario {

    // atributos
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String login;
    private String senha;
    private TipoUsuario tipoUsuario;
    private int limiteEmprestimo;

    // construtores
    public Usuario() {
    }

    public Usuario(
            int id,
            String nome,
            String cpf,
            String email,
            String login,
            String senha,
            TipoUsuario tipoUsuario,
            int limiteEmprestimo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.limiteEmprestimo = limiteEmprestimo;
    }


    // gets
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public int getLimiteEmprestimo() {
        return limiteEmprestimo;
    }

    // sets
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setLimiteEmprestimo(int limiteEmprestimo) {
        this.limiteEmprestimo = limiteEmprestimo;
    }

    @Override
    public String toString() {
        // Define como o usuario aparece nas listagens do sistema.
        return "ID: " + id +
                "\nNome: " + nome +
                "\nTipo de Usuario: " + tipoUsuario;
    }
}
