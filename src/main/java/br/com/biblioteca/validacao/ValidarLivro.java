package validacao;

import model.Livro;

public class ValidarLivro {

    // metodos
    public void validarLivro(Livro livro) {

        if (livro.getTitulo() == null || livro.getTitulo().trim().isEmpty()) {
            throw new IllegalArgumentException("O tÃ­tulo Ã© obrigatÃ³rio.");
        }

        if (livro.getAutor() == null || livro.getAutor().trim().isEmpty()) {
            throw new IllegalArgumentException("O autor Ã© obrigatÃ³rio.");
        }

        if (String.valueOf(livro.getAnoLancamento()).length() != 4) {
            System.out.println("O ano deve ter 4 dÃ­gitos");
        }

        if (livro.getQuantidadeTotal() < 0) {
            throw new IllegalArgumentException("Quantidade total invÃ¡lida.");
        }

        if (livro.getQuantidadeDisponivel() < 0 || livro.getQuantidadeDisponivel() < livro.getQuantidadeTotal()) {
            throw new IllegalArgumentException("Quantidade disponÃ­vel invÃ¡lida.");
        }
    }
}
