package br.com.biblioteca.util;

import br.com.biblioteca.model.Emprestimo;
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.model.Usuario;

import java.util.List;

public class GeradorIdUtil {

    public static int gerarProximoIdLivro(List<Livro> livros) {
        int maiorId = 0;

        for (Livro livro : livros) {
            if (livro.getId() > maiorId) {
                maiorId = livro.getId();
            }
        }

        return maiorId + 1;
    }

    public static int gerarProximoIdUsuario(List<Usuario> usuarios) {
        int maiorId = 0;

        for (Usuario usuario : usuarios) {
            if (usuario.getId() > maiorId) {
                maiorId = usuario.getId();
            }
        }

        return maiorId + 1;
    }

    public static int gerarProximoIdEmprestimo(List<Emprestimo> emprestimos) {
        int maiorId = 0;

        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getId() > maiorId) {
                maiorId = emprestimo.getId();
            }
        }

        return maiorId + 1;
    }
}
