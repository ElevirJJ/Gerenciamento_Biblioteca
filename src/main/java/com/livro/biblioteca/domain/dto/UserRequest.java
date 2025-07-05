package com.livro.biblioteca.domain.dto;

import com.livro.biblioteca.domain.entity.User;

public record UserRequest(String nome, String email, String telefone) {
    public UserRequest (User usuario){
        this(usuario.getNome(), usuario.getEmail(), usuario.getTelefone());
    }
}
