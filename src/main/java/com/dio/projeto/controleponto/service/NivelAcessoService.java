package com.dio.projeto.controleponto.service;

import com.dio.projeto.controleponto.model.NivelAcesso;
import com.dio.projeto.controleponto.repository.NivelAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NivelAcessoService {

    @Autowired
    NivelAcessoRepository nivelAcessoRepository;

    public List<NivelAcesso> getAll(){
        return nivelAcessoRepository.findAll();
    }

    public Optional<NivelAcesso> getById(Long id){
        return nivelAcessoRepository.findById(id);
    }

    public NivelAcesso save(NivelAcesso nivelAcesso){
        return nivelAcessoRepository.save(nivelAcesso);
    }

    public void deleteById(Long id){
        nivelAcessoRepository.deleteById(id);
    }
}
