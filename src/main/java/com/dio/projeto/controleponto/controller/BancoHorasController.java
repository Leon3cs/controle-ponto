package com.dio.projeto.controleponto.controller;

import com.dio.projeto.controleponto.model.BancoHoras;
import com.dio.projeto.controleponto.model.compositeKeys.BancoHorasId;
import com.dio.projeto.controleponto.service.BancoHorasService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banco-horas")
public class BancoHorasController {

    @Autowired
    BancoHorasService bancoHorasService;

    @PostMapping
    public ResponseEntity<BancoHoras> createBancoHoras(@RequestBody BancoHoras bancoHoras){
        return ResponseEntity.ok(bancoHorasService.save(bancoHoras));
    }

    @GetMapping
    public ResponseEntity<List<BancoHoras>> getBancoHoras(){
        return ResponseEntity.ok(bancoHorasService.getAll());
    }

    @GetMapping("/{bancoHorasId}/{movimentacaoId}/{usuarioId}")
    public ResponseEntity<?> getBancoHora(@PathVariable("bancoHorasId") Long bancoHorasId, @PathVariable("movimentacaoId") Long movimentacaoId, @PathVariable("usuarioId") Long usuarioId){
        try{
            BancoHorasId id = new BancoHorasId(bancoHorasId, movimentacaoId, usuarioId);
            BancoHoras bancoHoras = bancoHorasService.getById(id).orElseThrow(() -> new NotFoundException("Registro nao encontrado"));
            return ResponseEntity.ok(bancoHoras);
        }catch(NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<BancoHoras> updateBancoHoras(@RequestBody BancoHoras bancoHoras){
        return ResponseEntity.ok(bancoHorasService.save(bancoHoras));
    }

    @DeleteMapping("/{bancoHorasId}/{movimentacaoId}/{usuarioId}")
    public ResponseEntity<?> deleteBancoHora(@PathVariable("bancoHorasId") Long bancoHorasId, @PathVariable("movimentacaoId") Long movimentacaoId, @PathVariable("usuarioId") Long usuarioId){
        try{
            BancoHorasId id = new BancoHorasId(bancoHorasId, movimentacaoId, usuarioId);
            bancoHorasService.deleteById(id);
            return ResponseEntity.ok(1);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
