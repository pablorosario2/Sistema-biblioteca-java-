package main.java.br.com.biblioteca.repository;

import main.java.br.com.biblioteca.model.Emprestimo;
import main.java.br.com.biblioteca.enums.StatusEmprestimo;
import model.Livro;
import model.Usuario;

import java.io.*;
import java.util.ArrayList;

public class repositoryLivros {
    public void salvarLivros(ArrayList<model.Livro> livros) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("data/livros.txt"))) {

            for (model.Livro livro : livros) {

                writer.write(
                      "ID: " + livro.getId() + ";" +
                                "Título: " + livro.getTitulo() + ";" +
                                "Autor: " + livro.getAutor() + ";" +
                                "Ano de Lançamento: " + livro.getAnoLancamento() + ";" +
                                "ISBN: " + livro.getIsbn() + ";" +
                                "Categoria: " + livro.getCategoria() + ";" +
                                "Quantidade Total: " + livro.getQuantidadeTotal() + ";" +
                                "Quantidade Disponível: " + livro.getQuantidadeDisponivel()
                );

                writer.newLine();
            }

            System.out.println("Livros salvos com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar os livros: " + e.getMessage());
        }
    }

    public ArrayList<model.Livro> carregarLivros() {
        ArrayList<model.Livro> livros = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/livros.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                model.Livro livro = new model.Livro(
                        Integer.parseInt(dados[0].split(": ")[1].trim()),
                        dados[1].split(": ")[1].trim(),
                        dados[2].split(": ")[1].trim(),
                        Integer.parseInt(dados[3].split(": ")[1].trim()),
                        enums.CategoriaLivro.valueOf(dados[5].split(": ")[1].trim()),
                        dados[4].split(": ")[1].trim(),
                        Integer.parseInt(dados[6].split(": ")[1].trim()),
                        Integer.parseInt(dados[7].split(": ")[1].trim())
                );

                livros.add(livro);
            }

        } catch (IOException e) {

            System.out.println("Erro ao carregar livros.");
            e.printStackTrace();

        }

        return livros;
    }
}
