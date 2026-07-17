package br.com.biblioteca.util;

import java.time.LocalDate;

public class DataUtil {

    // atributos
    // métodos
    public LocalDate hoje() {
        return LocalDate.now();
    }

    public LocalDate calcularPrevisaoDevolucao(LocalDate dataEmprestimo) {
        return dataEmprestimo.plusDays(7);
    }

}
