package com.dio.projeto.controleponto.service;

import com.dio.projeto.controleponto.model.BancoHoras;
import com.dio.projeto.controleponto.model.compositeKeys.BancoHorasId;
import com.dio.projeto.controleponto.repository.BancoHorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoHorasService {

    @Autowired
    BancoHorasRepository bancoHorasRepository;

    public List<BancoHoras> getAll(){
        return bancoHorasRepository.findAll();
    }

    public Optional<BancoHoras> getById(BancoHorasId id){
        return bancoHorasRepository.findById(id);
    }

    public BancoHoras save(BancoHoras bancoHoras){
        return bancoHorasRepository.save(bancoHoras);
    }

    public void deleteById(BancoHorasId id){
        bancoHorasRepository.deleteById(id);
    }
}
