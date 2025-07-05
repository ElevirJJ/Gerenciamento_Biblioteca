package com.livro.biblioteca.controller;

import com.livro.biblioteca.domain.dto.BookRequest;
import com.livro.biblioteca.domain.entity.Book;
import com.livro.biblioteca.domain.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
@RequiredArgsConstructor
public class BookController {

    private final LivroService livroService;

    @PostMapping
    public ResponseEntity <Void> createLivro (@RequestBody BookRequest request){
        livroService.cadastro(request);
        return ResponseEntity.ok().build();
    }


    @GetMapping
    public ResponseEntity <List<Book>> list (){
        var listGet = livroService.get();
        return ResponseEntity.ok(listGet);
    }

    @GetMapping("/{id}")
    public ResponseEntity <BookRequest> buscarPeloID (@PathVariable Long id){
        var dados = livroService.getID(id);
        return ResponseEntity.ok(new BookRequest(dados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable Long id){
        livroService.deleteID(id);
        return ResponseEntity.ok().build();
    }


}
