import main.java.br.com.biblioteca.service.LivroService;
import main.java.br.com.biblioteca.service.UsuarioService;

public class Main {

    // metodo principal
    public static void main(String[] args) {

        // servicos
        LivroService livroService = new LivroService();
        UsuarioService usuarioService = new UsuarioService();

        // execucoes
        livroService.listarLivros();
        usuarioService.listarUsuarios();
        usuarioService.buscarUsuarioPorId(2);
    }
}
