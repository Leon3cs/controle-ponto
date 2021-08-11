package com.dio.projeto.controleponto.service;

import com.dio.projeto.controleponto.model.Localidade;
import com.dio.projeto.controleponto.repository.LocalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadeService {

    @Autowired
    LocalidadeRepository localidadeRepository;

    public List<Localidade> getAll(){
        return localidadeRepository.findAll();
    }

    public Optional<Localidade> getById(Long id){
        return localidadeRepository.findById(id);
    }

    public Localidade save(Localidade localidade){
        return localidadeRepository.save(localidade);
    }

    public void deleteById(Long id){
        localidadeRepository.deleteById(id);
    }
}
