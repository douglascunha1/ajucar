package com.ajucar.strategy;

import com.ajucar.entity.Veiculo;
import com.ajucar.enums.TipoVeiculo;
import com.ajucar.request.VeiculoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class VeiculoContext {

    private final Map<TipoVeiculo, VeiculoStrategy> strategies = new HashMap<>();

    @Autowired
    public VeiculoContext(CarroStrategy carroStrategy, MotoStrategy motoStrategy) {
        strategies.put(TipoVeiculo.CARRO, carroStrategy);
        strategies.put(TipoVeiculo.MOTO, motoStrategy);
    }

    public Veiculo salvarVeiculo(VeiculoRequest veiculoRequest) {
        VeiculoStrategy strategy = strategies.get(veiculoRequest.getTipoVeiculo());
        if (strategy == null) {
            throw new IllegalArgumentException("Tipo de veículo não suportado: " + veiculoRequest.getTipoVeiculo());
        }
        return strategy.salvar(veiculoRequest);
    }

    public Veiculo atualizarVeiculo(Long id, VeiculoRequest veiculoRequest) {
        VeiculoStrategy strategy = strategies.get(veiculoRequest.getTipoVeiculo());
        if (strategy == null) {
            throw new IllegalArgumentException("Tipo de veículo não suportado: " + veiculoRequest.getTipoVeiculo());
        }
        return strategy.atualizar(id, veiculoRequest);
    }
}