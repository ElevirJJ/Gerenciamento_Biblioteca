package com.livro.biblioteca.repository;

import com.livro.biblioteca.domain.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Autor, Long> {
}
