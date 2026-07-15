package repository;

import main.java.br.com.biblioteca.model.Emprestimo;
import main.java.br.com.biblioteca.enums.StatusEmprestimo;
import model.Livro;
import model.Usuario;

import java.io.*;
import java.util.ArrayList;

public class ArquivoRepository {

    // metodos salvar
    public void salvarLivros(ArrayList<Livro> livros) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("data/livros.txt"))) {

            for (Livro livro : livros) {

                writer.write(
                        livro.getId() + ";" +
                                livro.getTitulo() + ";" +
                                livro.getAutor() + ";" +
                                livro.getAnoLancamento() + ";" +
                                livro.getIsbn() + ";" +
                                livro.getCategoria() + ";" +
                                livro.getQuantidadeTotal() + ";" +
                                livro.getQuantidadeDisponivel()
                );

                writer.newLine();
            }

            System.out.println("Livros salvos com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar os livros: " + e.getMessage());
        }
    }

    public void salvarUsuarios(ArrayList<Usuario> usuarios) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("data/usuarios.txt"))) {

            for (Usuario usuario : usuarios) {

                writer.write(
                        usuario.getId() + ";" +
                                usuario.getNome() + ";" +
                                usuario.getCpf() + ";" +
                                usuario.getLogin() + ";" +
                                usuario.getSenha() + ";" +
                                usuario.getTipoUsuario() + ";" +
                                usuario.getLimiteEmprestimo()
                );

                writer.newLine();
            }

            System.out.println("UsuÃ¡rios salvos com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar os usuÃ¡rios: " + e.getMessage());
        }
    }

    public void salvarEmprestimos(ArrayList<Emprestimo> emprestimos) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("data/emprestimos.txt"))) {

            for (Emprestimo emprestimo : emprestimos) {

                writer.write(
                        emprestimo.getId() + ";" +
                                emprestimo.getIdUsuario() + ";" +
                                emprestimo.getIdLivro() + ";" +
                                emprestimo.getDataEmprestimo() + ";" +
                                emprestimo.getDataPrevistaDevolucao() + ";" +
                                emprestimo.getDataDevolucao() + ";" +
                                emprestimo.getStatusEmprestimo()
                );

                writer.newLine();
            }

            System.out.println("EmprÃ©stimos salvos com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar os emprÃ©stimos: " + e.getMessage());
        }
    }

    // metodos carregar
    public ArrayList<Livro> carregarLivros() {
        ArrayList<Livro> livros = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/livros.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                Livro livro = new Livro(
                        Integer.parseInt(dados[0]),
                        dados[1],
                        dados[2],
                        Integer.parseInt(dados[3]),
                        enums.CategoriaLivro.valueOf(dados[5]),
                        dados[4],
                        Integer.parseInt(dados[6]),
                        Integer.parseInt(dados[7])
                );

                livros.add(livro);
            }

        } catch (IOException e) {

            System.out.println("Erro ao carregar livros.");
            e.printStackTrace();

        }

        return livros;
    }

    public ArrayList<Usuario> carregarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/usuarios.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                Usuario usuario = new Usuario(
                        Integer.parseInt(dados[0]),
                        dados[1],
                        dados[2],
                        dados[3],
                        dados[4],
                        enums.TipoUsuario.valueOf(dados[5]),
                        Integer.parseInt(dados[6])
                );

                usuarios.add(usuario);
            }

        } catch (IOException e) {

            System.out.println("Erro ao carregar usuÃ¡rios.");
            e.printStackTrace();

        }

        return usuarios;
    }

    public ArrayList<Emprestimo> carregarEmprestimos() {
        ArrayList<Emprestimo> emprestimos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/emprestimos.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                Emprestimo emprestimo = new Emprestimo(
                        Integer.parseInt(dados[0]),
                        Integer.parseInt(dados[1]),
                        Integer.parseInt(dados[2]),
                        Integer.parseInt(dados[3]),
                        dados[4],
                        dados[5],
                        StatusEmprestimo.valueOf(dados[6])
                );

                emprestimos.add(emprestimo);
            }

        } catch (IOException e) {

            System.out.println("Erro ao carregar emprÃ©stimos.");
            e.printStackTrace();

        }

        return emprestimos;
    }
}
