package com.livro.biblioteca.domain.service;

import com.livro.biblioteca.domain.dto.UserRequest;
import com.livro.biblioteca.domain.entity.User;
import com.livro.biblioteca.domain.exception.exerciseGlobal;
import com.livro.biblioteca.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser (UserRequest request){
        var userDados = new User(request.nome(), request.email(), request.telefone());
        userRepository.save(userDados);

    }

    public List<User> getList (){
       return userRepository.findAll();
    }

    public User bucarPeloID (Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new exerciseGlobal("ID não existi no banco"));
    }

    public void deleteID (Long id){
        userRepository.deleteById(id);
    }
}
