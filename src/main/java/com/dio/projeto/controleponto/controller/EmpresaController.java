package com.dio.projeto.controleponto.controller;

import com.dio.projeto.controleponto.model.Empresa;
import com.dio.projeto.controleponto.service.EmpresaService;
import javassist.NotFoundException;
import javassist.expr.Expr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Empresa> createEmpresa(@RequestBody Empresa empresa){
        return ResponseEntity.ok(empresaService.save(empresa));
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> getAllEmpresa(){
        return ResponseEntity.ok(empresaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmpresa(@PathVariable("id") Long id){
        try{
            Empresa empresa = empresaService.getById(id).orElseThrow(() -> new NotFoundException("Registro não encontrado"));
            return ResponseEntity.ok(empresa);
        }catch(NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Empresa> updateEmpresa(@RequestBody Empresa empresa){
        return ResponseEntity.ok(empresaService.save(empresa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmpresa(@PathVariable("id") Long id){
        try{
            empresaService.deleteById(id);
            return ResponseEntity.ok(1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
