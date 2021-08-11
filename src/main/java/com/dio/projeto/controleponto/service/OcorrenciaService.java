package com.dio.projeto.controleponto.service;

import com.dio.projeto.controleponto.model.Ocorrencia;
import com.dio.projeto.controleponto.repository.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OcorrenciaService {

    @Autowired
    OcorrenciaRepository ocorrenciaRepository;

    public List<Ocorrencia> getAll(){
        return ocorrenciaRepository.findAll();
    }

    public Optional<Ocorrencia> getById(Long id){
        return ocorrenciaRepository.findById(id);
    }

    public Ocorrencia save(Ocorrencia ocorrencia){
        return ocorrenciaRepository.save(ocorrencia);
    }

    public void deleteById(Long id){
        ocorrenciaRepository.deleteById(id);
    }
}
