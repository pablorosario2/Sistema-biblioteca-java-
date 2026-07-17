package br.com.biblioteca.model;

import br.com.biblioteca.enums.CategoriaLivro;

public class Livro {

    // atributos
    private int id;
    private String titulo;
    private String autor;
    private int anoLancamento;
    private CategoriaLivro categoria;
    private String isbn;
    private int quantidadeTotal;
    private int quantidadeDisponivel;

    // construtores
    public Livro() {
    }

    public Livro(
            int id,
            String titulo,
            String autor,
            int anoLancamento,
            CategoriaLivro categoria,
            String isbn,
            int quantidadeTotal,
            int quantidadeDisponivel) {

        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoLancamento = anoLancamento;
        this.categoria = categoria;
        this.isbn = isbn;
        this.quantidadeTotal = quantidadeTotal;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    // gets
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public CategoriaLivro getCategoria() {
        return categoria;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    // sets
    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void setCategoria(CategoriaLivro categoria) {
        this.categoria = categoria;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    @Override
    public String toString() {
        // Define como o livro aparece quando usamos System.out.println(livro).
        return "ID: " + id +
                "\nTitulo: " + titulo +
                "\nAutor: " + autor +
                "\nAno de Lancamento: " + anoLancamento +
                "\nCategoria: " + categoria +
                "\nISBN: " + isbn +
                "\nQuantidade Total: " + quantidadeTotal +
                "\nQuantidade Disponivel: " + quantidadeDisponivel;
    }
}
