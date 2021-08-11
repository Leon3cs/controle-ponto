package com.dio.projeto.controleponto.controller;

import com.dio.projeto.controleponto.model.NivelAcesso;
import com.dio.projeto.controleponto.service.NivelAcessoService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/nivel-acesso")
public class NivelAcessoController {

    @Autowired
    NivelAcessoService nivelAcessoService;

    @PostMapping
    public ResponseEntity<NivelAcesso> create(@RequestBody NivelAcesso nivelAcesso){
        return ResponseEntity.ok(nivelAcessoService.save(nivelAcesso));
    }

    @GetMapping
    public ResponseEntity<List<NivelAcesso>> getAllNivelAcesso(){
        return ResponseEntity.ok(nivelAcessoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByIdNivelAcesso(@PathVariable("id") Long id) {
        try{
            NivelAcesso nivelAcesso = nivelAcessoService.getById(id).orElseThrow(() -> new NotFoundException("Nenhum registro encontrado"));
            return ResponseEntity.ok(nivelAcesso);
        }catch(NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<NivelAcesso> update(@RequestBody NivelAcesso nivelAcesso){
        return ResponseEntity.ok(nivelAcessoService.save(nivelAcesso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNivelAcesso(@PathVariable("id") Long id){
        try{
            nivelAcessoService.deleteById(id);
            return ResponseEntity.ok(1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Ocorreu um erro: "+e.getMessage());
        }
    }
}
