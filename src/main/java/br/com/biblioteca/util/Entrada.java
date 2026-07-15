package util;

import java.util.Scanner;

public class Entrada {

    // atributos
    Scanner entrada = new Scanner(System.in);

    // leitura de numeros
    public int LerOpcao() {
        int opcao = entrada.nextInt();
        entrada.nextLine();
        return opcao;
    }

    public int LerId() {
        int id = entrada.nextInt();
        entrada.nextLine();
        return id;
    }

    public int LerTipoUsuario() {
        int tipoUsuario = entrada.nextInt();
        entrada.nextLine();
        return tipoUsuario;
    }

    public int LerQuantidadeDisponivel() {
        int quantidadeDisponivel = entrada.nextInt();
        entrada.nextLine();
        return quantidadeDisponivel;
    }

    public int LerQuantidadeTotal() {
        int quantidadeTotal = entrada.nextInt();
        entrada.nextLine();
        return quantidadeTotal;
    }

    public int LerAnoLancamento() {
        int anoLancamento = entrada.nextInt();
        entrada.nextLine();
        return anoLancamento;
    }

    // leitura de textos
    public String LerTexto() {
        return entrada.nextLine();
    }

    public String LerNome() {
        return entrada.nextLine();
    }

    public String LerTitulo() {
        return entrada.nextLine();
    }

    public String LerAutor() {
        return entrada.nextLine();
    }

    public String LerCategoriaLivro() {
        return entrada.nextLine();
    }

    public String LerCpf() {
        return entrada.nextLine();
    }

    public String LerIsbn() {
        return entrada.nextLine();
    }

    public String LerLogin() {
        return entrada.nextLine();
    }

    public String LerSenha() {
        return entrada.nextLine();
    }
}
