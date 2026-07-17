package br.com.biblioteca.repository;

import br.com.biblioteca.enums.TipoUsuario;
import br.com.biblioteca.exception.ArquivoException;
import br.com.biblioteca.model.Usuario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UsuarioRepository {

    // Recebe uma lista de usuários que será salva no arquivo.
    public void salvarUsuarios(ArrayList<Usuario> usuarios) {

        // Abre o arquivo para escrita e fecha automaticamente no final.
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("data/usuarios.txt"))) {

            // Percorre todos os usuários existentes na lista.
            for (Usuario usuario : usuarios) {

                // Escreve o ID do usuário.
                writer.write("ID: " + usuario.getId());
                writer.newLine();

                // Escreve o nome do usuário.
                writer.write("Nome: " + usuario.getNome());
                writer.newLine();

                // Escreve o CPF do usuário.
                writer.write("CPF: " + usuario.getCpf());
                writer.newLine();

                // Escreve o e-mail do usuário.
                writer.write("Email: " + usuario.getEmail());
                writer.newLine();

                // Escreve o login do usuário.
                writer.write("Login: " + usuario.getLogin());
                writer.newLine();

                // Escreve a senha do usuário.
                writer.write("Senha: " + usuario.getSenha());
                writer.newLine();

                // Escreve o tipo do usuário.
                writer.write("Tipo de Usuario: " + usuario.getTipoUsuario());
                writer.newLine();

                // Escreve o limite de empréstimos do usuário.
                writer.write("Limite de Emprestimos: "
                        + usuario.getLimiteEmprestimo());
                writer.newLine();

                // Cria uma linha vazia entre um usuário e outro.
                writer.newLine();
            }

            // Mostra uma mensagem depois que todos forem salvos.
            System.out.println("Usuarios salvos com sucesso!");

        } catch (IOException e) {

            // Caso ocorra um erro de escrita, lança a exceção personalizada.
            throw new ArquivoException(
                    "Erro ao salvar os usuarios: " + e.getMessage()
            );
        }
    }

    // Lê o arquivo e retorna uma lista de usuários.
    public ArrayList<Usuario> carregarUsuarios() {

        // Cria uma lista vazia para receber os usuários carregados.
        ArrayList<Usuario> usuarios = new ArrayList<>();

        // Abre o arquivo para leitura.
        try (BufferedReader reader =
                     new BufferedReader(new FileReader("data/usuarios.txt"))) {

            // Variável que receberá cada linha lida.
            String linha;

            // Continua lendo enquanto existirem linhas.
            while ((linha = reader.readLine()) != null) {

                // Ignora as linhas vazias entre os usuários.
                if (linha.trim().isEmpty()) {
                    continue;
                }

                // Array que armazenará os oito campos do usuário.
                String[] dados;

                // Verifica se os dados estão na mesma linha.
                if (linha.contains(";")) {

                    // Separa os campos utilizando o ponto e vírgula.
                    dados = linha.split(";");

                } else {

                    // Cria um array com oito posições.
                    dados = new String[8];

                    // A primeira linha já foi lida pelo while.
                    dados[0] = linha;

                    // Lê as próximas sete linhas do usuário.
                    for (int i = 1; i < dados.length; i++) {
                        dados[i] = reader.readLine();
                    }
                }

                // Cria um novo usuário com os dados encontrados no arquivo.
                Usuario usuario = new Usuario(

                        // Pega o ID e converte para int.
                        Integer.parseInt(
                                dados[0].split(": ")[1].trim()
                        ),

                        // Pega o nome como String.
                        dados[1].split(": ")[1].trim(),

                        // Pega o CPF como String.
                        dados[2].split(": ")[1].trim(),

                        // Pega o e-mail como String.
                        dados[3].split(": ")[1].trim(),

                        // Pega o login como String.
                        dados[4].split(": ")[1].trim(),

                        // Pega a senha como String.
                        dados[5].split(": ")[1].trim(),

                        // Converte o texto para o enum TipoUsuario.
                        TipoUsuario.valueOf(
                                dados[6].split(": ")[1].trim()
                        ),

                        // Pega o limite de empréstimos e converte para int.
                        Integer.parseInt(
                                dados[7].split(": ")[1].trim()
                        )
                );

                // Adiciona o usuário criado à lista.
                usuarios.add(usuario);
            }

        } catch (IOException e) {

            // Caso ocorra um erro de leitura, lança a exceção personalizada.
            throw new ArquivoException(
                    "Erro ao carregar usuarios: " + e.getMessage()
            );
        }

        // Retorna todos os usuários encontrados no arquivo.
        return usuarios;
    }
}