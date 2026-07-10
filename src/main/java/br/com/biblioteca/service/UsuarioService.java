package service;

import java.util.ArrayList;

import enums.TipoUsuario;
import model.Usuario;

public class UsuarioService {
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void cadastrarUsuario(int id,
            String nome,
            String cpf,
            String login,
            String senha,
            TipoUsuario tipoUsuario,
            int limiteEmprestimo) {

        Usuario usuario = new Usuario(id,
                nome,
                cpf,
                login,
                senha,
                tipoUsuario,
                limiteEmprestimo);
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

}
