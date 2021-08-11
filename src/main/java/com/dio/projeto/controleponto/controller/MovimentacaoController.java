package com.dio.projeto.controleponto.controller;

import com.dio.projeto.controleponto.model.Movimentacao;
import com.dio.projeto.controleponto.model.compositeKeys.MovimentacaoId;
import com.dio.projeto.controleponto.service.MovimentacaoService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    MovimentacaoService movimentacaoService;

    @PostMapping
    public ResponseEntity<Movimentacao> createMovimentacao(@RequestBody Movimentacao movimentacao){
        return ResponseEntity.ok(movimentacaoService.save(movimentacao));
    }

    @GetMapping
    public ResponseEntity<List<Movimentacao>> getMovimentacoes(){
        return ResponseEntity.ok(movimentacaoService.getAll());
    }

    @GetMapping("/{movimentacaoId}/{usuarioId}")
    public ResponseEntity<?> getMovimentacao(@PathVariable("movimentacaoId") Long movimentacaoId, @PathVariable("usuarioId") Long usuarioId){
        try{
            MovimentacaoId id = new MovimentacaoId(movimentacaoId, usuarioId);
            Movimentacao movimentacao = movimentacaoService.getById(id).orElseThrow(() -> new NotFoundException("Nenhum registro encontrado"));
            return ResponseEntity.ok(movimentacao);
        }catch(NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Movimentacao> updateMovimentacao(@RequestBody Movimentacao movimentacao){
        return ResponseEntity.ok(movimentacaoService.save(movimentacao));
    }

    @DeleteMapping("/{movimentacaoId}/{usuarioId}")
    public ResponseEntity<?> deleteMovimentacao(@PathVariable("movimentacaoId") Long movimentacaoId, @PathVariable("usuarioId") Long usuarioId){
        try{
            MovimentacaoId id = new MovimentacaoId(movimentacaoId, usuarioId);
            movimentacaoService.deleteById(id);
            return ResponseEntity.ok(1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
