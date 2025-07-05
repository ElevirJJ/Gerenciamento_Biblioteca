package com.livro.biblioteca.domain.service;

import com.livro.biblioteca.domain.dto.BookRequest;
import com.livro.biblioteca.domain.entity.Book;
import com.livro.biblioteca.domain.exception.exerciseGlobal;
import com.livro.biblioteca.repository.AuthorRepository;
import com.livro.biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;
    private final AuthorRepository authorRepository;

    public void cadastro (BookRequest dados){

        try {
            if (dados.quantidadeDisponivel() <= 0)
                throw new exerciseGlobal("Selecione um livro!!!");
          }catch (exerciseGlobal e){
            throw e;
        }

        var autor = authorRepository.findById(dados.autorId())
                .orElseThrow(() -> new exerciseGlobal("autor não exitir"));

        livroRepository.save(new Book(dados.titulo(), dados.quantidadeDisponivel(), autor ));
    }





    public List<Book> get(){
      return livroRepository.findAll();
    }

    public Book getID (Long id){
       return livroRepository.findById(id)
               .orElseThrow(() -> new exerciseGlobal("ID não existir no banco"));
    }

    public void deleteID (Long id){
        livroRepository.deleteById(id);
    }

}

