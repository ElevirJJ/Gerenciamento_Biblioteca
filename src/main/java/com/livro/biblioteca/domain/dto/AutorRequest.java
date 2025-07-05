package com.livro.biblioteca.domain.dto;

import com.livro.biblioteca.domain.entity.Autor;

public record AutorRequest(String nome, String nacionalidade) {
    public AutorRequest (Autor autor){
        this(autor.getNome(), autor.getNacionalidade());
    }
}
