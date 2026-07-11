package service;


import java.util.ArrayList;

import enums.TipoUsuario;
import model.Admin;
import model.Usuario;
import validacao.ValidarUsuario;

public class UsuarioService {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Admin> admins = new ArrayList<>();

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
        validarLogin();



        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    public void cadastrarAdmin(int id,
                               String nome,
                               String cpf,
                               String login,
                               String senha) {

        Admin admin = new Admin(id,
                nome,
                cpf,
                login,
                senha);
        admins.add(admin);
        System.out.println("Admin cadastrado com sucesso!");
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuario cadastrado!");
            return;
        }
        for (model.Usuario usuario : usuarios) {
        }
        System.out.println("-------------------");
        System.out.println(usuarios);
        System.out.println("-------------------");
    }

    public void buscarUsuarioPorId(int id) {
        for (model.Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                System.out.println("-------------------");
                System.out.println(usuario);
                System.out.println("-------------------");
                return;
            } else {
                System.out.println("Nenhum usuario encontrado");
            }
        }
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



}
