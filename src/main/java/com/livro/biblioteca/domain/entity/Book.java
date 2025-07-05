package com.livro.biblioteca.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "livros")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Integer quantidadeDisponivel;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Emprestimo> emprestimos;

    public Book(String titulo, Integer quantidadeDisponivel, Autor autor) {
        this.titulo = titulo;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.autor = autor;
    }


}
