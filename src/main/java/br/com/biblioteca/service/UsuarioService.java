package br.com.biblioteca.service;

import java.util.ArrayList;

import br.com.biblioteca.exception.LoginInvalidoException;
import br.com.biblioteca.exception.UsuarioNaoEncontradoException;
import br.com.biblioteca.repository.UsuarioRepository;
import br.com.biblioteca.validacao.ValidarUsuario;
import br.com.biblioteca.enums.TipoUsuario;
import br.com.biblioteca.model.Usuario;

import static br.com.biblioteca.util.GeradorIdUtil.gerarProximoIdUsuario;

public class UsuarioService {

    // atributos
    private final UsuarioRepository usuarioRepository = new UsuarioRepository();
    private final ArrayList<Usuario> usuarios = usuarioRepository.carregarUsuarios();
    private final ValidarUsuario validarUsuario = new ValidarUsuario();

    // métodos
    public void cadastrarUsuario(
                                 String nome,
                                 String cpf,
                                 String email,
                                 String login,
                                 String senha,
                                 TipoUsuario tipoUsuario) {
        int id = gerarProximoIdUsuario(usuarios);
        int limiteEmprestimo = 3;

        Usuario usuario = new Usuario(id,
                nome,
                cpf,
                email,
                login,
                senha,
                tipoUsuario,
                limiteEmprestimo);


        verificacoesNecessarias(nome, login, senha, cpf, tipoUsuario);

        usuarios.add(usuario);
        usuarioRepository.salvarUsuarios(usuarios);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    public void salvarUsuarios() {
        usuarioRepository.salvarUsuarios(usuarios);
    }

    public void verificacoesNecessarias(String nome, String login, String senha, String cpf, TipoUsuario tipoUsuario) {

        validarUsuario.validarNome(nome);
        validarUsuario.validarLoginDuplicado(login, usuarios);
        validarUsuario.validarCpfDuplicado(cpf, usuarios);
        validarUsuario.verificarTipoUsuario(tipoUsuario);
    }

    public Usuario validarLogin(String login, String senha) {
        Usuario usuario = validarUsuario.validarLogin(login, senha, usuarios);

        if (usuario == null) {
            throw new LoginInvalidoException("Login ou senha inválidos!");
        }

        return usuario;
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado!");
            return;
        }

        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
            System.out.println();
        }
    }

    public Usuario buscarUsuarioPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }

        throw new UsuarioNaoEncontradoException("Nenhum usuário encontrado com o ID " + id);
    }

    public void buscarUsuarioPorLogin(String login) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                System.out.println(usuario);
                System.out.println();
                return;
            }
        }

        System.out.println("Nenhum usuário encontrado");
    }

    // gets
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
