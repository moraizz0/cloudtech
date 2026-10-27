package com.cloudtech.biblioteca.controller;

import com.cloudtech.biblioteca.model.Livro;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final List<Livro> livros = new ArrayList<>();
    private final AtomicLong proximoId = new AtomicLong(1);

    // Listar todos os livros
    @GetMapping
    public List<Livro> listarLivros() {
        return livros;
    }

    // Cadastrar um novo livro
    @PostMapping("/cadastrar")
    public Livro cadastrarLivro(@RequestBody Livro livro) {

        livro.setId(proximoId.getAndIncrement());

        livros.add(livro);

        return livro;
    }

    
    // Consultar livro pelo ID
    @GetMapping("/{id}")
    public Livro buscarLivroPorId(@PathVariable Long id) {

        return livros.stream()
                .filter(livro -> livro.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Livro não encontrado"
                ));
    }

    
    // Alterar os dados de um livro
    @PutMapping("/alterar/{id}")
    public Livro alterarLivro(
            @PathVariable Long id,
            @RequestBody Livro dadosAtualizados) {

        Livro livro = buscarLivroPorId(id);

        livro.setTitulo(dadosAtualizados.getTitulo());
        livro.setAutor(dadosAtualizados.getAutor());
        livro.setEditora(dadosAtualizados.getEditora());
        livro.setAno(dadosAtualizados.getAno());
        livro.setCategoria(dadosAtualizados.getCategoria());
        livro.setStatus(dadosAtualizados.getStatus());

        return livro;
    }

}
