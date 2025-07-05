package com.livro.biblioteca.controller;

import com.livro.biblioteca.domain.dto.UserRequest;
import com.livro.biblioteca.domain.entity.User;
import com.livro.biblioteca.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity <Void> cadastro (@RequestBody UserRequest request){
        userService.createUser(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity <List<User>> get (){
        var listUsuer = userService.getList();
        return ResponseEntity.ok(listUsuer);
    }

    @GetMapping("/{id}")
    public ResponseEntity <UserRequest> buscarID (@PathVariable Long id){
       var dados = userService.bucarPeloID(id);
        return ResponseEntity.ok(new UserRequest(dados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteID (Long id){
        userService.deleteID(id);
        return ResponseEntity.ok().build();
    }
}
