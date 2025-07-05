package com.livro.biblioteca.domain.dto;
import com.livro.biblioteca.domain.entity.Book;

public record BookRequest(String titulo, Integer quantidadeDisponivel, Long autorId) {

        public BookRequest(Book livro){
            this(livro.getTitulo(), livro.getQuantidadeDisponivel(), livro.getId());
        }
}



