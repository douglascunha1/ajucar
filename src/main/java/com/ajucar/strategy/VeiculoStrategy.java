package com.ajucar.strategy;

import com.ajucar.entity.Veiculo;
import com.ajucar.request.VeiculoRequest;

public interface VeiculoStrategy {
    Veiculo salvar(VeiculoRequest veiculoRequest);
    Veiculo atualizar(Long id, VeiculoRequest veiculoRequest);
}