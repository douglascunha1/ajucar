package com.ajucar.controller;

import com.ajucar.entity.Veiculo;
import com.ajucar.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
@Validated
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping("/veiculos")
    public ResponseEntity<List<Veiculo>> listarTodosVeiculos(
            @RequestParam(required = false) Integer tipoVeiculo,
            @RequestParam(required = false) String cor,
            @RequestParam(required = false) String modelo,
            @RequestParam(required = false) String fabricante,
            @RequestParam(required = false) Optional<Integer> ano
    ) {
        List<Veiculo> veiculos = veiculoService.findAllVeiculos(tipoVeiculo, cor, modelo, fabricante, ano.orElse(null));
        return ResponseEntity.ok(veiculos);
    }
}