package com.dio.projeto.controleponto.controller;

import com.dio.projeto.controleponto.model.TipoData;
import com.dio.projeto.controleponto.service.TipoDataService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-data")
public class TipoDataController {

    @Autowired
    TipoDataService tipoDataService;

    @PostMapping
    public ResponseEntity<TipoData> create(@RequestBody TipoData tipoData){
        return ResponseEntity.ok(tipoDataService.save(tipoData));
    }

    @GetMapping
    public ResponseEntity<List<TipoData>> getAllTipoData(){
        return ResponseEntity.ok(tipoDataService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTipoData(@PathVariable("id") Long id){
        try{
            TipoData tipoData = tipoDataService.getById(id).orElseThrow(() -> new NotFoundException("Registro não encontrado"));
            return ResponseEntity.ok(tipoData);
        }catch(NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<TipoData> updateTipoData(@RequestBody TipoData tipoData){
        return ResponseEntity.ok(tipoDataService.save(tipoData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTipoData(@PathVariable("id") Long id){
        try{
            tipoDataService.deleteById(id);
            return ResponseEntity.ok(1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
