package com.dio.projeto.controleponto.controller;

import com.dio.projeto.controleponto.model.Calendario;
import com.dio.projeto.controleponto.service.CalendarioService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendario")
public class CalendarioController {

    @Autowired
    CalendarioService calendarioService;

    @PostMapping
    public ResponseEntity<Calendario> createCalendario(@RequestBody Calendario calendario){
        return ResponseEntity.ok(calendarioService.save(calendario));
    }

    @GetMapping
    public ResponseEntity<List<Calendario>> getCalendarios(){
        return ResponseEntity.ok(calendarioService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCalendario(@PathVariable("id") Long id){
        try{
            Calendario calendario = calendarioService.getById(id).orElseThrow(() -> new NotFoundException("Registro nao encontrado"));
            return ResponseEntity.ok(calendario);
        }catch(NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Calendario> updateCalendario(@RequestBody Calendario calendario){
        return ResponseEntity.ok(calendarioService.save(calendario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCalendario(@PathVariable("id") Long id){
        try{
            calendarioService.deleteById(id);
            return ResponseEntity.ok(1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
