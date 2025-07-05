package com.livro.biblioteca.domain.dto;

import com.livro.biblioteca.domain.entity.Emprestimo;

import java.time.LocalDateTime;

public record LoanRequest(LocalDateTime dataEmprestimo, LocalDateTime dataDevolucao, Long usuarioId, Long livroId) {
    public LoanRequest(Emprestimo emprestimo){
        this(emprestimo.getDataEmprestimo(), emprestimo.getDataDevolucao(), emprestimo.getLivro().getId(), emprestimo.getLivro().getId());
    }
}
