package com.livro.biblioteca.repository;

import com.livro.biblioteca.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Book, Long> {
}
