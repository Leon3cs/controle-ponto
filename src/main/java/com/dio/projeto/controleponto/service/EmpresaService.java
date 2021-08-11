package com.dio.projeto.controleponto.service;

import com.dio.projeto.controleponto.model.Empresa;
import com.dio.projeto.controleponto.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    public List<Empresa> getAll(){
        return empresaRepository.findAll();
    }

    public Optional<Empresa> getById(Long id){
        return empresaRepository.findById(id);
    }

    public Empresa save(Empresa empresa){
        return empresaRepository.save(empresa);
    }

    public void deleteById(Long id){
        empresaRepository.deleteById(id);
    }
}
