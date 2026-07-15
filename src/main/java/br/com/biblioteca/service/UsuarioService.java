package main.java.br.com.biblioteca.service;

import java.util.ArrayList;

import main.java.br.com.biblioteca.validacao.ValidarUsuario;
import enums.TipoUsuario;
import model.Admin;
import model.Usuario;

public class UsuarioService {

    // atributos
    private repository.ArquivoRepository repository = new repository.ArquivoRepository();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Admin> admins = new ArrayList<>();
    public ValidarUsuario ValidarUsuario = new ValidarUsuario();

    // metodos
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

        verificacoesNecessarias(nome, login, senha, cpf, tipoUsuario);

        usuarios.add(usuario);
        repository.salvarUsuarios(usuarios);
        System.out.println("UsuÃ¡rio cadastrado com sucesso!");
    }

    public void cadastrarAdmin(int id,
                               String nome,
                               String cpf,
                               String login,
                               String senha,
                               TipoUsuario tipoUsuario) {

        Admin admin = new Admin(id,
                nome,
                cpf,
                login,
                senha
        );

        verificacoesNecessarias(nome, login, senha, cpf, tipoUsuario);

        admins.add(admin);
        System.out.println("Admin cadastrado com sucesso!");
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuario cadastrado!");
            return;
        }

        for (model.Usuario usuario : usuarios) {

            System.out.println("-------------------");
            System.out.println(usuarios);
            System.out.println("-------------------");
        }
    }

    public Usuario buscarUsuarioPorId(int id) {
        for (model.Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        System.out.println("Nenhum usuario encontrado");
        return null;
    }

    public void buscarUsuarioPorLogin(String login) {
        for (model.Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                System.out.println("-------------------");
                System.out.println(usuario);
                System.out.println("-------------------");
                return;
            } else {
                System.out.println("Nenhum usuario encontrado");
            }
        }
    }

    public void verificacoesNecessarias(String nome, String login, String senha, String cpf, enums.TipoUsuario tipoUsuario) {

        if (nome.isEmpty()) {
            throw new IllegalArgumentException("Nome nÃ£o pode estar vazio");
        }

        ValidarUsuario.validarLogin(login, senha);
        ValidarUsuario.validarLoginDuplicado(login);
        ValidarUsuario.validarCpfDuplicado(cpf);
        ValidarUsuario.verificarTipoUsuario(tipoUsuario);
    };

    // gets
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }
}
