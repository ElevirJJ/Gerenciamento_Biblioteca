package com.livro.biblioteca.controller;

import com.livro.biblioteca.domain.dto.AutorRequest;
import com.livro.biblioteca.domain.entity.Autor;
import com.livro.biblioteca.domain.service.AutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
@RequiredArgsConstructor
public class AutorController {

    private final AutorService autorService;

    @PostMapping
    public ResponseEntity <Void> cadastro (@RequestBody AutorRequest dados){
        autorService.cadastroUsuario(dados);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity <List<Autor>> getList (){
        var dados = autorService.get();
        return ResponseEntity.ok(dados);
    }

    @GetMapping("/{id}")
    public ResponseEntity <AutorRequest> listID (@PathVariable Long id){
        var dados = autorService.buscarPeloID(id);
        return ResponseEntity.ok(new AutorRequest(dados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteID (@PathVariable Long id){
        autorService.deleteID(id);
        return ResponseEntity.ok().build();
    }


}
