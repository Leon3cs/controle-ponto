package com.dio.projeto.controleponto.service;

import com.dio.projeto.controleponto.model.Calendario;
import com.dio.projeto.controleponto.repository.CalendarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarioService {

    @Autowired
    CalendarioRepository calendarioRepository;

    public List<Calendario> getAll(){
        return calendarioRepository.findAll();
    }

    public Optional<Calendario> getById(Long id){
        return calendarioRepository.findById(id);
    }

    public Calendario save(Calendario calendario){
        return calendarioRepository.save(calendario);
    }

    public void deleteById(Long id){
        calendarioRepository.deleteById(id);
    }
}
