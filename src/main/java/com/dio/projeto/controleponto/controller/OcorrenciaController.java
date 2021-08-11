package com.dio.projeto.controleponto.controller;

import com.dio.projeto.controleponto.model.Ocorrencia;
import com.dio.projeto.controleponto.service.OcorrenciaService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {

    @Autowired
    OcorrenciaService ocorrenciaService;

    @PostMapping
    public ResponseEntity<Ocorrencia> createOcorrencia(@RequestBody Ocorrencia ocorrencia){
        return ResponseEntity.ok(ocorrenciaService.save(ocorrencia));
    }

    @GetMapping
    public ResponseEntity<List<Ocorrencia>> getAllOcorrencia(){
        return ResponseEntity.ok(ocorrenciaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOcorrencia(@PathVariable("id") Long id){
        try{
            Ocorrencia ocorrencia = ocorrenciaService.getById(id).orElseThrow(() -> new NotFoundException("Registro não encontrado"));
            return ResponseEntity.ok(ocorrencia);
        }catch(NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Ocorrencia> updateOcorrencia(@RequestBody Ocorrencia ocorrencia){
        return ResponseEntity.ok(ocorrenciaService.save(ocorrencia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOcorrencia(@PathVariable("id") Long id){
        try{
            ocorrenciaService.deleteById(id);
            return ResponseEntity.ok(1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
