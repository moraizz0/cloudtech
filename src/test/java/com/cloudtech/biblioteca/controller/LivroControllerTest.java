package com.cloudtech.biblioteca.controller;

import com.cloudtech.biblioteca.model.Livro;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LivroControllerTest {

    private Livro criarLivro() {
        Livro livro = new Livro();

        livro.setTitulo("Banco de Dados para Iniciantes");
        livro.setAutor("Maria Souza");
        livro.setEditora("EduTech");
        livro.setAno(2023);
        livro.setCategoria("Informática");
        livro.setStatus("Disponível");

        return livro;
    }

    @Test
    void testarCadastroLivro() {
        LivroController controller = new LivroController();

        Livro resultado = controller.cadastrarLivro(criarLivro());

        assertEquals(1L, resultado.getId());
        assertEquals("Banco de Dados para Iniciantes",
                     resultado.getTitulo());
        assertEquals("Disponível", resultado.getStatus());
    }

    @Test
    void testarListagemLivros() {
        LivroController controller = new LivroController();

        controller.cadastrarLivro(criarLivro());

        List<Livro> livros = controller.listarLivros();

        assertEquals(1, livros.size());
        assertEquals("Maria Souza", livros.get(0).getAutor());
    }

    @Test
    void testarConsultaPorId() {
        LivroController controller = new LivroController();

        controller.cadastrarLivro(criarLivro());

        Livro resultado = controller.buscarLivroPorId(1L);

        assertEquals(1L, resultado.getId());
        assertEquals("EduTech", resultado.getEditora());
    }

    @Test
    void testarAlteracaoLivro() {
        LivroController controller = new LivroController();

        controller.cadastrarLivro(criarLivro());

        Livro novosDados = criarLivro();
        novosDados.setTitulo("Banco de Dados Avançado");
        novosDados.setAno(2025);
        novosDados.setStatus("Emprestado");

        Livro resultado = controller.alterarLivro(1L, novosDados);

        assertEquals("Banco de Dados Avançado",
                     resultado.getTitulo());
        assertEquals(2025, resultado.getAno());
        assertEquals("Emprestado", resultado.getStatus());
    }

    @Test
    void testarLivroInexistente() {
        LivroController controller = new LivroController();

        ResponseStatusException erro = assertThrows(
            ResponseStatusException.class,
            () -> controller.buscarLivroPorId(999L)
        );

        assertEquals(HttpStatus.NOT_FOUND, erro.getStatusCode());
    }
}
