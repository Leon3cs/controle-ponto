package com.dio.projeto.controleponto.service;

import com.dio.projeto.controleponto.model.CategoriaUsuario;
import com.dio.projeto.controleponto.repository.CategoriaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaRepositoryService {

    @Autowired
    CategoriaUsuarioRepository categoriaUsuarioRepository;

    public List<CategoriaUsuario> getAll(){
        return categoriaUsuarioRepository.findAll();
    }

    public Optional<CategoriaUsuario> getById(Long id){
        return categoriaUsuarioRepository.findById(id);
    }

    public CategoriaUsuario save(CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioRepository.save(categoriaUsuario);
    }

    public void deleteById(Long id){
        categoriaUsuarioRepository.deleteById(id);
    }
}
