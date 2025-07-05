package com.livro.biblioteca.domain.service;

import com.livro.biblioteca.domain.dto.LoanRequest;
import com.livro.biblioteca.domain.entity.Emprestimo;
import com.livro.biblioteca.domain.entity.Book;
import com.livro.biblioteca.domain.exception.exerciseGlobal;
import com.livro.biblioteca.repository.EmprestimoRepository;
import com.livro.biblioteca.repository.LivroRepository;
import com.livro.biblioteca.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpretimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final UserRepository userRepository;
    private final LivroRepository livroRepository;



    public void emprestimoLivro (Book livraria){
        try {
            if (livraria.getQuantidadeDisponivel() <= 0)
                throw new exerciseGlobal("Livro indisponível para empréstimo");
            livraria.setQuantidadeDisponivel(livraria.getQuantidadeDisponivel() - 1);
            livroRepository.save(livraria);
        }catch (exerciseGlobal e){
            throw e;
        }
    }

    public void devolverLivro (Long id){
        var emprestimo = emprestimoRepository.findById(id)
                .orElseThrow(() -> new exerciseGlobal("emprestimo não encontrado"));

        try {
            if (emprestimo.getDataDevolucao() != null)
                throw new exerciseGlobal("Esse livro já foi devolvido");
        }catch (exerciseGlobal e){
            throw e;
        }

        emprestimo.setDataDevolucao(java.time.LocalDateTime.now());
        emprestimoRepository.save(emprestimo);

        var livro = emprestimo.getLivro();
        livro.setQuantidadeDisponivel(livro.getQuantidadeDisponivel() + 1);
        livroRepository.save(livro);
    }



    public void createEmprestimo (LoanRequest request){
        var usuario = userRepository.findById(request.usuarioId())
                .orElseThrow(() -> new exerciseGlobal("erro ao criar um usúario"));

        var livro = livroRepository.findById(request.livroId())
                .orElseThrow(() -> new exerciseGlobal("erro ao criar um livro"));

        emprestimoLivro(livro);


        emprestimoRepository.save(new Emprestimo(request.dataEmprestimo(), request.dataDevolucao(), usuario, livro));
    }


    public List <Emprestimo> get (){
        return emprestimoRepository.findAll();
    }

    public Emprestimo bucarPeloId (Long id){
        return emprestimoRepository.findById(id)
                .orElseThrow(() -> new exerciseGlobal("id não existir no banco"));
    }

    public void deletePeloId (Long id){
        emprestimoRepository.deleteById(id);
    }


}
