package main.java.br.com.biblioteca.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DataUtil {

    // atributos
    Scanner entrada = new Scanner(System.in);

    // metodos
    public LocalDate LerData() {
        return LocalDate.parse(entrada.nextLine());
    }

    public LocalDate hoje() {
        return LocalDate.now();
    }

    public String FormtarData(LocalDate data) {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatador);
    }

    public String FormtarDataAoOriginal(LocalDate data) {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatador);
    }

    public String ConverterDataString(LocalDate data) {
        return data.toString();
    }

    public LocalDate converterStringData(String data) {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataFormatada = LocalDate.parse(data, formatador);
        return dataFormatada;
    }


    public LocalDate PrevisaoDevolicao(LocalDate Hoje) {
        Hoje = hoje();
        LocalDate PrevisaoDevolicao = Hoje.plusDays(7);
        return PrevisaoDevolicao;
    }


}
