package com.dio.projeto.controleponto.controller;

import com.dio.projeto.controleponto.model.Localidade;
import com.dio.projeto.controleponto.service.LocalidadeService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {

    @Autowired
    LocalidadeService localidadeService;

    @PostMapping
    public ResponseEntity<Localidade> createLocalidade(@RequestBody Localidade localidade){
        return ResponseEntity.ok(localidadeService.save(localidade));
    }

    @GetMapping
    public ResponseEntity<List<Localidade>> getLocalidades(){
        return ResponseEntity.ok(localidadeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLocalidade(@PathVariable("id") Long id){
        try{
            Localidade localidade = localidadeService.getById(id).orElseThrow(() -> new NotFoundException("Registro não encontrado"));
            return ResponseEntity.ok(localidade);
        }catch(NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Localidade> updateLocalidade(@RequestBody Localidade localidade){
        return ResponseEntity.ok(localidadeService.save(localidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLocalidade(@PathVariable("id") Long id){
        try{
            localidadeService.deleteById(id);
            return ResponseEntity.ok(1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
