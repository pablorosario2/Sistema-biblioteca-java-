package main.java.br.com.biblioteca.repository;

import main.java.br.com.biblioteca.model.Emprestimo;
import main.java.br.com.biblioteca.enums.StatusEmprestimo;
import model.Livro;
import model.Usuario;

import java.io.*;
import java.util.ArrayList;

public class repositoryEmprestimo {

    public void salvarEmprestimos(ArrayList<Emprestimo> emprestimos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/emprestimos.txt"))) {
            for (Emprestimo emprestimo : emprestimos) {
                writer.write(
                        "ID: " + emprestimo.getId() + ";" +
                                "ID do Usuário: " + emprestimo.getIdUsuario() + ";" +
                                "ID do Livro: " + emprestimo.getIdLivro() + ";" +
                                "Data de Empréstimo: " + emprestimo.getDataEmprestimo() + ";" +
                                "Data Prevista de Devolução: " + emprestimo.getDataPrevistaDevolucao() + ";" +
                                "Data de Devolução: " + emprestimo.getDataDevolucao() + ";" +
                                "Status: " + emprestimo.getStatusEmprestimo());
                writer.newLine();
            }
            System.out.println("Emprestimos salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os emprÃ©stimos: " + e.getMessage());
        }
    }

    public ArrayList<Emprestimo> carregarEmprestimos() {
        ArrayList<Emprestimo> emprestimos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/emprestimos.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                Emprestimo emprestimo = new Emprestimo(

                        Integer.parseInt(dados[0].split(": ")[1].trim()),
                        Integer.parseInt(dados[1].split(": ")[1].trim()),
                        Integer.parseInt(dados[2].split(": ")[1].trim()),
                        Integer.parseInt(dados[3].split(": ")[1].trim()),
                        dados[4].split(": ")[1].trim(),
                        dados[5].split(": ")[1].trim(),
                        StatusEmprestimo.valueOf(dados[6].split(": ")[1].trim()));

                emprestimos.add(emprestimo);
            }

        } catch (IOException e) {

            System.out.println("Erro ao carregar emprÃ©stimos.");
            e.printStackTrace();

        }

        return emprestimos;
    }

}
