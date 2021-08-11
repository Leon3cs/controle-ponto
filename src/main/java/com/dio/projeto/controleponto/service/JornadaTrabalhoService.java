package com.dio.projeto.controleponto.service;

import com.dio.projeto.controleponto.model.JornadaTrabalho;
import com.dio.projeto.controleponto.repository.JornadaTrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JornadaTrabalhoService {

    @Autowired
    JornadaTrabalhoRepository jornadaTrabalhoRepository;

    public JornadaTrabalho save(JornadaTrabalho jornadaTrabalho){
        return jornadaTrabalhoRepository.save(jornadaTrabalho);
    }

    public List<JornadaTrabalho> getAll(){
        return jornadaTrabalhoRepository.findAll();
    }

    public Optional<JornadaTrabalho> getById(Long id){
        return jornadaTrabalhoRepository.findById(id);
    }

    public void deleteById(Long id){
        jornadaTrabalhoRepository.deleteById(id);
    }
}
