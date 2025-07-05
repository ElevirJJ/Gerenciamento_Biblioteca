package com.livro.biblioteca.repository;

import com.livro.biblioteca.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
