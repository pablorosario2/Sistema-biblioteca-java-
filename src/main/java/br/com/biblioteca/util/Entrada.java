package br.com.biblioteca.util;

import java.util.Scanner;

public class Entrada {

    private final Scanner entrada = new Scanner(System.in);

    private int lerInteiro(String mensagemErro) {
        while (true) {
            String valor = entrada.nextLine();

            try {
                return Integer.parseInt(valor.trim());
            } catch (NumberFormatException e) {
                System.out.println(mensagemErro);
            }
        }
    }

    public int lerOpcao() {
        return lerInteiro("Digite uma opção válida.");
    }

    public int lerId() {
        return lerInteiro("Digite um ID válido.");
    }

    public int lerTipoUsuario() {
        return lerInteiro("Digite um tipo de usuário válido.");
    }

    public int lerQuantidadeDisponivel() {
        return lerInteiro("Digite uma quantidade disponível válida.");
    }

    public int lerQuantidadeTotal() {
        return lerInteiro("Digite uma quantidade total válida.");
    }

    public int lerAnoLancamento() {
        return lerInteiro("Digite um ano válido.");
    }

    public String lerTexto() {
        return entrada.nextLine().trim();
    }

    public String lerNome() {
        return entrada.nextLine().trim();
    }

    public String lerTitulo() {
        return entrada.nextLine().trim();
    }

    public String lerAutor() {
        return entrada.nextLine().trim();
    }

    public String lerCategoriaLivro() {
        return entrada.nextLine().trim();
    }

    public String lerCpf() {
        return entrada.nextLine().trim();
    }

    public String lerEmail() {
        return entrada.nextLine().trim();
    }

    public String lerIsbn() {
        return entrada.nextLine().trim();
    }

    public String lerLogin() {
        return entrada.nextLine().trim();
    }

    public String lerSenha() {
        return entrada.nextLine();
    }
}