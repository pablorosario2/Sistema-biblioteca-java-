package br.com.biblioteca.repository;

import br.com.biblioteca.exception.ArquivoException;
import br.com.biblioteca.model.Emprestimo;
import br.com.biblioteca.enums.StatusEmprestimo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmprestimoRepository {

    // Recebe uma lista de empréstimos que será salva no arquivo.
    public void salvarEmprestimos(ArrayList<Emprestimo> emprestimos) {

        // Abre o arquivo para escrita e fecha automaticamente quando terminar.
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("data/emprestimos.txt"))) {

            // Percorre todos os empréstimos existentes na lista.
            for (Emprestimo emprestimo : emprestimos) {

                // Escreve o ID do empréstimo.
                writer.write("ID: " + emprestimo.getId());
                writer.newLine();

                // Escreve o ID do usuário que pegou o livro.
                writer.write("ID do Usuario: " + emprestimo.getIdUsuario());
                writer.newLine();

                // Escreve o ID do livro emprestado.
                writer.write("ID do Livro: " + emprestimo.getIdLivro());
                writer.newLine();

                // Escreve a data em que o empréstimo foi realizado.
                writer.write("Data de Emprestimo: " + emprestimo.getDataEmprestimo());
                writer.newLine();

                // Escreve a data prevista para devolução.
                writer.write("Data Prevista de Devolucao: "
                        + emprestimo.getDataPrevistaDevolucao());
                writer.newLine();

                // Escreve a data real da devolução. Pode ser null.
                writer.write("Data de Devolucao: " + emprestimo.getDataDevolucao());
                writer.newLine();

                // Escreve o status do empréstimo.
                writer.write("Status: " + emprestimo.getStatusEmprestimo());
                writer.newLine();

                // Cria uma linha vazia entre um empréstimo e outro.
                writer.newLine();
            }

            // Mostra uma mensagem depois que todos forem salvos.
            System.out.println("Emprestimos salvos com sucesso!");

        } catch (IOException e) {

            // Caso ocorra um erro de escrita, lança a exceção personalizada.
            throw new ArquivoException(
                    "Erro ao salvar os emprestimos: " + e.getMessage()
            );
        }
    }

    // Lê o arquivo e retorna uma lista de empréstimos.
    public ArrayList<Emprestimo> carregarEmprestimos() {

        // Cria uma lista vazia para receber os empréstimos carregados.
        ArrayList<Emprestimo> emprestimos = new ArrayList<>();

        // Abre o arquivo para leitura e fecha automaticamente no final.
        try (BufferedReader reader =
                     new BufferedReader(new FileReader("data/emprestimos.txt"))) {

            // Variável que receberá cada linha do arquivo.
            String linha;

            // Continua lendo enquanto ainda existirem linhas.
            while ((linha = reader.readLine()) != null) {

                // Ignora as linhas vazias entre os empréstimos.
                if (linha.trim().isEmpty()) {
                    continue;
                }

                // Array que armazenará os sete campos do empréstimo.
                String[] dados;

                // Verifica se os dados estão todos na mesma linha.
                if (linha.contains(";")) {

                    // Separa os campos utilizando o ponto e vírgula.
                    dados = linha.split(";");

                } else {

                    // Cria um array com sete posições.
                    dados = new String[7];

                    // A primeira linha já foi lida pelo while.
                    dados[0] = linha;

                    // Lê as próximas seis linhas do empréstimo.
                    for (int i = 1; i < dados.length; i++) {
                        dados[i] = reader.readLine();
                    }
                }

                // Pega somente o valor da data de devolução.
                String dataDevolucaoTexto =
                        dados[5].split(": ")[1].trim();

                // Cria um novo empréstimo com os dados encontrados no arquivo.
                Emprestimo emprestimo = new Emprestimo(

                        // Pega o ID e converte de String para int.
                        Integer.parseInt(
                                dados[0].split(": ")[1].trim()
                        ),

                        // Pega o ID do usuário e converte para int.
                        Integer.parseInt(
                                dados[1].split(": ")[1].trim()
                        ),

                        // Pega o ID do livro e converte para int.
                        Integer.parseInt(
                                dados[2].split(": ")[1].trim()
                        ),

                        // Pega a data do empréstimo e converte para LocalDate.
                        LocalDate.parse(
                                dados[3].split(": ")[1].trim()
                        ),

                        // Pega a data prevista e converte para LocalDate.
                        LocalDate.parse(
                                dados[4].split(": ")[1].trim()
                        ),

                        // Caso seja "null" ou vazio, recebe null.
                        // Caso contrário, converte o texto para LocalDate.
                        dataDevolucaoTexto.equals("null")
                                || dataDevolucaoTexto.isEmpty()
                                ? null
                                : LocalDate.parse(dataDevolucaoTexto),

                        // Converte o texto do status para StatusEmprestimo.
                        StatusEmprestimo.valueOf(
                                dados[6].split(": ")[1].trim()
                        )
                );

                // Adiciona o empréstimo criado à lista.
                emprestimos.add(emprestimo);
            }

        } catch (IOException e) {

            // Caso ocorra um erro de leitura, lança a exceção personalizada.
            throw new ArquivoException(
                    "Erro ao carregar emprestimos: " + e.getMessage()
            );
        }

        // Retorna todos os empréstimos encontrados no arquivo.
        return emprestimos;
    }
}