package com.dio.projeto.controleponto.controller;

import com.dio.projeto.controleponto.model.CategoriaUsuario;
import com.dio.projeto.controleponto.service.CategoriaRepositoryService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria-usuario")
public class CategoriaUsuarioController {

    @Autowired
    CategoriaRepositoryService categoriaRepositoryService;

    @PostMapping
    public ResponseEntity<CategoriaUsuario> createCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario){
        return ResponseEntity.ok(categoriaRepositoryService.save(categoriaUsuario));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaUsuario>> getAllCategoriaUsuario(){
        return ResponseEntity.ok(categoriaRepositoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoriaUsuario(@PathVariable("id") Long id){
        try{
            CategoriaUsuario categoriaUsuario = categoriaRepositoryService.getById(id).orElseThrow(() -> new NotFoundException("Registro não encontrado"));
            return ResponseEntity.ok(categoriaUsuario);
        }catch(NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<CategoriaUsuario> updateCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario){
        return ResponseEntity.ok(categoriaRepositoryService.save(categoriaUsuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategoriaUsuario(@PathVariable("id") Long id){
        try{
            categoriaRepositoryService.deleteById(id);
            return ResponseEntity.ok(1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
