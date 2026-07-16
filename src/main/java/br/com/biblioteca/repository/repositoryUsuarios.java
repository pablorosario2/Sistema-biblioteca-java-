package main.java.br.com.biblioteca.repository;

import main.java.br.com.biblioteca.model.Emprestimo;
import main.java.br.com.biblioteca.enums.StatusEmprestimo;
import model.Livro;
import model.Usuario;

import java.io.*;
import java.util.ArrayList;
public class repositoryUsuarios {

    public void salvarUsuarios(ArrayList<model.Usuario> usuarios) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("data/usuarios.txt"))) {

            for (model.Usuario usuario : usuarios) {

                writer.write(
                        "ID: " + usuario.getId() + ";" +
                                "Nome: " + usuario.getNome() + ";" +
                                "CPF: " + usuario.getCpf() + ";" +
                                "Login: " + usuario.getLogin() + ";" +
                                "Senha: " + usuario.getSenha() + ";" +
                                "Tipo de Usuário: " + usuario.getTipoUsuario() + ";" +
                                "Limite de Empréstimos: " + usuario.getLimiteEmprestimo()
                );

                writer.newLine();
            }

            System.out.println("Usuários salvos com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar os usuários: " + e.getMessage());
        }
    }

    public ArrayList<model.Usuario> carregarUsuarios() {
        ArrayList<model.Usuario> usuarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/usuarios.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                model.Usuario usuario = new model.Usuario(
                        Integer.parseInt(dados[0].split(": ")[1].trim()),
                        dados[1].split(": ")[1].trim(),
                        dados[2].split(": ")[1].trim(),
                        dados[3].split(": ")[1].trim(),
                        dados[4].split(": ")[1].trim(),
                        enums.TipoUsuario.valueOf(dados[5].split(": ")[1].trim()),
                        Integer.parseInt(dados[6].split(": ")[1].trim())
                );

                usuarios.add(usuario);
            }

        } catch (IOException e) {

            System.out.println("Erro ao carregar usuários.");
            e.printStackTrace();

        }

        return usuarios;
    }

}
