package com.dio.projeto.controleponto.controller;

import com.dio.projeto.controleponto.model.JornadaTrabalho;
import com.dio.projeto.controleponto.service.JornadaTrabalhoService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jornada-trabalho")
public class JornadaTrabalhoController {

    @Autowired
    JornadaTrabalhoService jornadaTrabalhoService;

    @PostMapping
    public ResponseEntity<JornadaTrabalho> createJornadaTrabalho(@RequestBody JornadaTrabalho jornadaTrabalho){
        return ResponseEntity.ok(jornadaTrabalhoService.save(jornadaTrabalho));
    }

    @GetMapping
    public ResponseEntity<List<JornadaTrabalho>> getAllJornadas(){
        return ResponseEntity.ok(jornadaTrabalhoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JornadaTrabalho> getJornadaById(@PathVariable("id") Long id) throws NotFoundException {
        return ResponseEntity.ok(jornadaTrabalhoService.getById(id).orElseThrow(() -> new NotFoundException("A jornada solicitada não existe")));
    }

    @PutMapping
    public ResponseEntity<JornadaTrabalho> updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return ResponseEntity.ok(jornadaTrabalhoService.save(jornadaTrabalho));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJornada(@PathVariable("id") Long id){
        try{
            jornadaTrabalhoService.deleteById(id);
            return (ResponseEntity<?>) ResponseEntity.ok();
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Ocorreu um erro: "+e.getMessage());
        }
    }
}
