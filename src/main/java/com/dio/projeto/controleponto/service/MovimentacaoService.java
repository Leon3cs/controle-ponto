package com.dio.projeto.controleponto.service;

import com.dio.projeto.controleponto.model.Movimentacao;
import com.dio.projeto.controleponto.model.compositeKeys.MovimentacaoId;
import com.dio.projeto.controleponto.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {

    @Autowired
    MovimentacaoRepository movimentacaoRepository;

    public List<Movimentacao> getAll(){
        return movimentacaoRepository.findAll();
    }

    public Optional<Movimentacao> getById(MovimentacaoId id){
        return movimentacaoRepository.findById(id);
    }

    public Movimentacao save(Movimentacao movimentacao){
        return movimentacaoRepository.save(movimentacao);
    }

    public void deleteById(MovimentacaoId id){
        movimentacaoRepository.deleteById(id);
    }
}
