package com.ajucar.strategy;

import com.ajucar.entity.Carro;
import com.ajucar.enums.TipoVeiculo;
import com.ajucar.request.VeiculoRequest;
import com.ajucar.repository.CarroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarroStrategy implements VeiculoStrategy {

    @Autowired
    private CarroRepository carroRepository;

    @Override
    public Carro salvar(VeiculoRequest veiculoRequest) {
        Carro carro = new Carro();
        carro.setModelo(veiculoRequest.getModelo());
        carro.setFabricante(veiculoRequest.getFabricante());
        carro.setAno(veiculoRequest.getAno());
        carro.setPreco(veiculoRequest.getPreco());
        carro.setQuantidadePortas(veiculoRequest.getQuantidadePortas());
        carro.setTipoCombustivel(veiculoRequest.getTipoCombustivel());
        carro.setCor(veiculoRequest.getCor());
        carro.setTipoVeiculo(TipoVeiculo.CARRO);

        return carroRepository.save(carro);
    }

    @Override
    public Carro atualizar(Long id, VeiculoRequest veiculoRequest) {
        Carro carro = carroRepository.findCarroById(id);
        if (carro == null) {
            throw new EntityNotFoundException("Carro não encontrado com o ID: " + id);
        }

        carro.setModelo(veiculoRequest.getModelo());
        carro.setFabricante(veiculoRequest.getFabricante());
        carro.setAno(veiculoRequest.getAno());
        carro.setPreco(veiculoRequest.getPreco());
        carro.setQuantidadePortas(veiculoRequest.getQuantidadePortas());
        carro.setCor(veiculoRequest.getCor());
        carro.setTipoCombustivel(veiculoRequest.getTipoCombustivel());

        return carroRepository.save(carro);
    }
}