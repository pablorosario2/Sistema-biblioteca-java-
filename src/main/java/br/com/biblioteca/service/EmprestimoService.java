package br.com.biblioteca.service;

import br.com.biblioteca.enums.StatusEmprestimo;
import br.com.biblioteca.exception.EmprestimoInvalidoException;
import br.com.biblioteca.model.Emprestimo;
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.model.Usuario;
import br.com.biblioteca.repository.EmprestimoRepository;
import br.com.biblioteca.util.DataUtil;
import br.com.biblioteca.validacao.ValidarEmprestimo;
import br.com.biblioteca.service.UsuarioService;
import br.com.biblioteca.service.LivroService;

import java.time.LocalDate;
import java.util.ArrayList;

import static br.com.biblioteca.util.GeradorIdUtil.gerarProximoIdEmprestimo;

public class EmprestimoService {

    // atributos
    private final ValidarEmprestimo validarEmprestimo = new ValidarEmprestimo();
    private final EmprestimoRepository emprestimoRepository = new EmprestimoRepository();
    private final ArrayList<Emprestimo> emprestimos = emprestimoRepository.carregarEmprestimos();
    private final LivroService livroService = new LivroService();
    private final UsuarioService usuarioService = new UsuarioService();
    private final DataUtil data = new DataUtil();

    // métodos
    public void cadastrarEmprestimo(int idUsuario,
                                    int idLivro) {

        int id = gerarProximoIdEmprestimo(emprestimos);
        LocalDate dataEmprestimo = data.hoje();
        LocalDate dataPrevistaDevolucao = data.calcularPrevisaoDevolucao(dataEmprestimo);
        LocalDate dataDevolucao = null;
        StatusEmprestimo statusEmprestimo = StatusEmprestimo.ATIVO;

        validacoesEmprestimos(idUsuario, idLivro);

        Emprestimo emprestimo = new Emprestimo(id,
                idUsuario,
                idLivro,
                dataEmprestimo,
                dataPrevistaDevolucao,
                dataDevolucao,
                statusEmprestimo);

        emprestimos.add(emprestimo);
        emprestimoRepository.salvarEmprestimos(emprestimos);
        System.out.println("Empréstimo cadastrado com sucesso!");
    }

    public void validacoesEmprestimos(int idUsuario, int idLivro) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(idUsuario);
        Livro livro = livroService.buscarLivroPorId(idLivro);

        validarEmprestimo.descontarEmprestimo(usuario, livro);
        usuarioService.salvarUsuarios();
        livroService.salvarLivros();
    }

    public Emprestimo buscarEmprestimoPorId(int id) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getId() == id) {
                return emprestimo;
            }
        }

        throw new EmprestimoInvalidoException("Nenhum empréstimo encontrado com o ID " + id);
    }

    public void listarEmprestimo() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo cadastrado!");
            return;
        }

        for (Emprestimo emprestimo : this.emprestimos) {
            System.out.println(emprestimo);
            System.out.println();
        }
    }

    public void listarEmprestimosAtivos(StatusEmprestimo statusEmprestimo) {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo cadastrado!");
            return;
        }

        for (Emprestimo emprestimo : this.emprestimos) {
            if (emprestimo.getStatusEmprestimo() == statusEmprestimo) {
                System.out.println(emprestimo);
                System.out.println();
            }
        }
    }

    public void listarEmprestimosPorUsuario(int idUsuario) {
        boolean encontrou = false;

        for (Emprestimo emprestimo : this.emprestimos) {
            if (emprestimo.getIdUsuario() == idUsuario) {
                System.out.println(emprestimo);
                System.out.println();
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum empréstimo encontrado para este usuário");
        }
    }

    public void listarHistoricoEmprestimo(int idUsuario) {
        listarEmprestimosPorUsuario(idUsuario);
    }

    public void verificarStatusEmprestimo(Emprestimo emprestimo) {
        if (emprestimo.getStatusEmprestimo() == StatusEmprestimo.DEVOLVIDO) {
            throw new EmprestimoInvalidoException("Esse empréstimo já foi devolvido.");
        }
    }

    public void adicionarDataDevolucao(int id, LocalDate dataDevolucao) {
        Emprestimo emprestimoEncontrado = buscarEmprestimoPorId(id);

        verificarStatusEmprestimo(emprestimoEncontrado);

        emprestimoEncontrado.setDataDevolucao(dataDevolucao);
        emprestimoEncontrado.setStatusEmprestimo(StatusEmprestimo.DEVOLVIDO);
        emprestimoRepository.salvarEmprestimos(emprestimos);

        Livro livroEncontrado = livroService.buscarLivroPorId(emprestimoEncontrado.getIdLivro());
        livroEncontrado.setQuantidadeDisponivel(livroEncontrado.getQuantidadeDisponivel() + 1);
        livroService.salvarLivros();

        Usuario usuarioEncontrado = usuarioService.buscarUsuarioPorId(emprestimoEncontrado.getIdUsuario());
        usuarioEncontrado.setLimiteEmprestimo(usuarioEncontrado.getLimiteEmprestimo() + 1);
        usuarioService.salvarUsuarios();

        System.out.println("Livro devolvido com sucesso!");
    }
}
