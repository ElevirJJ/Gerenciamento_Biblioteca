package com.livro.biblioteca.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "emprestimos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "usuario_id")
    private User usuario;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "livro_id")
    private Book livro;

    public Emprestimo(LocalDateTime dataEmprestimo, LocalDateTime dataDevolucao, User usuario, Book livro) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.usuario = usuario;
        this.livro = livro;
    }
}
