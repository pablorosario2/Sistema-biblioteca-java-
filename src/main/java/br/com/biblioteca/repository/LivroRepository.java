
        package br.com.biblioteca.repository;

import br.com.biblioteca.enums.CategoriaLivro;
import br.com.biblioteca.exception.ArquivoException;
import br.com.biblioteca.model.Livro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LivroRepository {

    // Método que recebe uma lista de livros e salva no arquivo livros.txt.
    public void salvarLivros(ArrayList<Livro> livros) {

        // Abre o arquivo para escrita.
        // O try-with-resources fecha o arquivo automaticamente no final.
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("data/livros.txt"))) {

            // Percorre todos os livros existentes dentro da lista.
            for (Livro livro : livros) {

                // Escreve o ID do livro no arquivo.
                writer.write("ID: " + livro.getId());

                // Pula para a próxima linha.
                writer.newLine();

                // Escreve o título do livro.
                writer.write("Titulo: " + livro.getTitulo());

                // Pula para a próxima linha.
                writer.newLine();

                // Escreve o nome do autor do livro.
                writer.write("Autor: " + livro.getAutor());

                // Pula para a próxima linha.
                writer.newLine();

                // Escreve o ano de lançamento do livro.
                writer.write("Ano de Lancamento: " + livro.getAnoLancamento());

                // Pula para a próxima linha.
                writer.newLine();

                // Escreve o ISBN do livro.
                writer.write("ISBN: " + livro.getIsbn());

                // Pula para a próxima linha.
                writer.newLine();

                // Escreve a categoria do livro.
                writer.write("Categoria: " + livro.getCategoria());

                // Pula para a próxima linha.
                writer.newLine();

                // Escreve a quantidade total de exemplares.
                writer.write("Quantidade Total: " + livro.getQuantidadeTotal());

                // Pula para a próxima linha.
                writer.newLine();

                // Escreve a quantidade de exemplares disponíveis.
                writer.write("Quantidade Disponivel: " + livro.getQuantidadeDisponivel());

                // Pula para a próxima linha.
                writer.newLine();

                // Cria uma linha vazia para separar um livro do próximo.
                writer.newLine();
            }

            // Mostra uma mensagem no console após salvar todos os livros.
            System.out.println("Livros salvos com sucesso!");

        } catch (IOException e) {

            // Caso ocorra algum erro ao abrir ou escrever no arquivo,
            // lança a exceção personalizada ArquivoException.
            throw new ArquivoException(
                    "Erro ao salvar os livros: " + e.getMessage()
            );
        }
    }

    // Método que lê o arquivo livros.txt e retorna uma lista de livros.
    public ArrayList<Livro> carregarLivros() {

        // Cria uma lista vazia para armazenar os livros carregados.
        ArrayList<Livro> livros = new ArrayList<>();

        // Abre o arquivo para leitura.
        // O arquivo será fechado automaticamente no final.
        try (BufferedReader reader =
                     new BufferedReader(new FileReader("data/livros.txt"))) {

            // Variável que receberá cada linha lida do arquivo.
            String linha;

            // Continua lendo enquanto ainda existirem linhas no arquivo.
            while ((linha = reader.readLine()) != null) {

                // Verifica se a linha está vazia.
                if (linha.trim().isEmpty()) {

                    // Ignora a linha vazia e continua para a próxima repetição.
                    continue;
                }

                // Declara um array que armazenará os dados do livro.
                String[] dados;

                // Verifica se os dados estão todos na mesma linha,
                // separados por ponto e vírgula.
                if (linha.contains(";")) {

                    // Divide a linha sempre que encontrar um ponto e vírgula.
                    dados = linha.split(";");

                } else {

                    // Cria um array com oito posições,
                    // pois cada livro possui oito informações.
                    dados = new String[8];

                    // A primeira linha já foi lida pelo while.
                    // Ela representa o ID do livro.
                    dados[0] = linha;

                    // Começa na posição 1 porque a posição 0 já foi preenchida.
                    for (int i = 1; i < dados.length; i++) {

                        // Lê a próxima linha e salva na posição atual do array.
                        dados[i] = reader.readLine();
                    }
                }

                // Cria um novo objeto Livro usando os dados lidos do arquivo.
                Livro livro = new Livro(

                        // Pega o valor do ID e converte de String para int.
                        Integer.parseInt(
                                dados[0].split(": ")[1].trim()
                        ),

                        // Pega o título do livro.
                        dados[1].split(": ")[1].trim(),

                        // Pega o nome do autor.
                        dados[2].split(": ")[1].trim(),

                        // Pega o ano de lançamento e converte para int.
                        Integer.parseInt(
                                dados[3].split(": ")[1].trim()
                        ),

                        // Pega o texto da categoria e converte para CategoriaLivro.
                        CategoriaLivro.valueOf(
                                dados[5].split(": ")[1].trim()
                        ),

                        // Pega o ISBN do livro.
                        dados[4].split(": ")[1].trim(),

                        // Pega a quantidade total e converte para int.
                        Integer.parseInt(
                                dados[6].split(": ")[1].trim()
                        ),

                        // Pega a quantidade disponível e converte para int.
                        Integer.parseInt(
                                dados[7].split(": ")[1].trim()
                        )
                );

                // Adiciona o livro criado à lista de livros.
                livros.add(livro);
            }

        } catch (IOException e) {

            // Caso ocorra algum erro ao abrir ou ler o arquivo,
            // lança a exceção personalizada ArquivoException.
            throw new ArquivoException(
                    "Erro ao carregar livros: " + e.getMessage()
            );
        }

        // Retorna a lista contendo todos os livros carregados.
        return livros;
    }
}

