package com.livro.biblioteca.controller;

import com.livro.biblioteca.domain.dto.LoanRequest;
import com.livro.biblioteca.domain.entity.Emprestimo;
import com.livro.biblioteca.domain.service.EmpretimoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
@RequiredArgsConstructor
public class LoanController {

    private final EmpretimoService empretimoService;

    @PostMapping
    public ResponseEntity <Void> cadastro (@RequestBody LoanRequest request){
        empretimoService.createEmprestimo(request);
        return ResponseEntity.ok().build();
    }


    @GetMapping
    public ResponseEntity <List<Emprestimo>> ListGet (){
        var list = empretimoService.get();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity <LoanRequest> bucarpeloID (@PathVariable Long id){
        var get = empretimoService.bucarPeloId(id);
        return ResponseEntity.ok(new LoanRequest(get));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> delete (@PathVariable Long id){
        empretimoService.deletePeloId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/devolver")
    public ResponseEntity<Void> devolver(@PathVariable Long id) {
        empretimoService.devolverLivro(id);
        return ResponseEntity.ok().build();
    }
}
