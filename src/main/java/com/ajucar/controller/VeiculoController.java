package com.ajucar.controller;

import com.ajucar.entity.Veiculo;
import com.ajucar.request.VeiculoRequest;
import com.ajucar.service.VeiculoService;
import com.ajucar.strategy.VeiculoContext;
import jakarta.validation.Valid;
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

    @Autowired
    private VeiculoContext veiculoContext;

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

    @PostMapping("/veiculos")
    public ResponseEntity<?> salvarVeiculo(@Valid @RequestBody VeiculoRequest veiculoRequest) {
        Veiculo veiculoSalvo = veiculoContext.salvarVeiculo(veiculoRequest);
        return ResponseEntity.ok(veiculoSalvo);
    }

    @GetMapping("/veiculos/{id}")
    public ResponseEntity<Veiculo> buscarVeiculoPorId(@PathVariable Long id) {
        Veiculo veiculo = veiculoService.findVeiculoById(id);
        return ResponseEntity.ok(veiculo);
    }

    @PutMapping("/veiculos/{id}")
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable Long id, @Valid @RequestBody VeiculoRequest veiculoRequest) {
        Veiculo veiculo = veiculoContext.atualizarVeiculo(id, veiculoRequest);
        return ResponseEntity.ok(veiculo);
    }

    @DeleteMapping("/veiculos/{id}")
    public ResponseEntity<Void> excluirVeiculo(@PathVariable Long id) {
        veiculoService.deleteVeiculoById(id);
        return ResponseEntity.noContent().build();
    }
}