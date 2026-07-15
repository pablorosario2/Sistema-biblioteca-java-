package main.java.br.com.biblioteca.validacao;

import main.java.br.com.biblioteca.model.Emprestimo;
import main.java.br.com.biblioteca.service.LivroService;
import main.java.br.com.biblioteca.service.UsuarioService;

public class ValidarEmprestimo {

    // atributos
    private model.Usuario usuario;
    private model.Livro livro;
    UsuarioService usuarioService = new UsuarioService();
    LivroService livroService = new LivroService();

    // metodos
    public void verificarLimite() {

        if (usuario.getLimiteEmprestimo() <= 0) {
            throw new IllegalArgumentException("Usuario nÃ£o tem mais emprestimo disponivel");
        } else if (usuario.getLimiteEmprestimo() >= 0) {
            int limiteemprestimo = usuario.getLimiteEmprestimo();
            usuario.setLimiteEmprestimo(limiteemprestimo - 1);
        }
    }

    public void descontarEmprestimo(int id) {
        model.Usuario usuario1 = usuarioService.buscarUsuarioPorId(id);
        usuario1.setLimiteEmprestimo(usuario1.getLimiteEmprestimo() - 1);

        model.Livro livro1 = livroService.buscarLivroPorId(id);
        livro1.setQuantidadeDisponivel(livro1.getQuantidadeDisponivel() - 1);

    }
}
