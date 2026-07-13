import main.java.br.com.biblioteca.service.LivroService;
import main.java.br.com.biblioteca.service.UsuarioService;

public class Main {

    public static void main(String[] args) {
        LivroService livroService = new LivroService();
        UsuarioService usuarioService = new UsuarioService();

        livroService.listarLivros();
        usuarioService.listarUsuarios();
        usuarioService.buscarUsuarioPorId(2);
    }
}