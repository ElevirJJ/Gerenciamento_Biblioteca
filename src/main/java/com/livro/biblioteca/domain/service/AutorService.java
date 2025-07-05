package com.livro.biblioteca.domain.service;

import com.livro.biblioteca.domain.dto.AutorRequest;
import com.livro.biblioteca.domain.entity.Autor;
import com.livro.biblioteca.domain.exception.exerciseGlobal;
import com.livro.biblioteca.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorService {

    private final AuthorRepository authorRepository;

    public void cadastroUsuario (AutorRequest dados){
        var dadosAutor = new Autor(dados.nome(), dados.nacionalidade());
        authorRepository.save(dadosAutor);
    }

    public List <Autor> get (){
        return authorRepository.findAll();
    }

    public Autor buscarPeloID (Long id){
        return authorRepository.findById(id)
                .orElseThrow(() -> new exerciseGlobal("ID não existir no banco"));
    }

    public void deleteID (Long id){
        authorRepository.deleteById(id);
    }

}
