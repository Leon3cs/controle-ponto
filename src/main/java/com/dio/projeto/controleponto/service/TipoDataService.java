package com.dio.projeto.controleponto.service;

import com.dio.projeto.controleponto.model.TipoData;
import com.dio.projeto.controleponto.repository.TipoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDataService {

    @Autowired
    TipoDataRepository tipoDataRepository;

    public List<TipoData> getAll(){
        return tipoDataRepository.findAll();
    }

    public Optional<TipoData> getById(Long id){
        return tipoDataRepository.findById(id);
    }

    public TipoData save(TipoData tipoData){
        return tipoDataRepository.save(tipoData);
    }

    public void deleteById(Long id){
        tipoDataRepository.deleteById(id);
    }
}
