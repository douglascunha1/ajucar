package com.ajucar.strategy;

import com.ajucar.entity.Moto;
import com.ajucar.enums.TipoVeiculo;
import com.ajucar.request.VeiculoRequest;
import com.ajucar.repository.MotoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MotoStrategy implements VeiculoStrategy {

    @Autowired
    private MotoRepository motoRepository;

    @Override
    public Moto salvar(VeiculoRequest veiculoRequest) {
        Moto moto = new Moto();
        moto.setModelo(veiculoRequest.getModelo());
        moto.setFabricante(veiculoRequest.getFabricante());
        moto.setAno(veiculoRequest.getAno());
        moto.setPreco(veiculoRequest.getPreco());
        moto.setCilindrada(veiculoRequest.getCilindrada());
        moto.setCor(veiculoRequest.getCor());
        moto.setTipoVeiculo(TipoVeiculo.MOTO);
        return motoRepository.save(moto);
    }

    @Override
    public Moto atualizar(Long id, VeiculoRequest veiculoRequest) {
        Moto moto = motoRepository.findMotoById(id);
        if (moto == null) {
            throw new EntityNotFoundException("Moto não encontrada com o ID: " + id);
        }

        moto.setModelo(veiculoRequest.getModelo());
        moto.setFabricante(veiculoRequest.getFabricante());
        moto.setAno(veiculoRequest.getAno());
        moto.setPreco(veiculoRequest.getPreco());
        moto.setCor(veiculoRequest.getCor());
        moto.setCilindrada(veiculoRequest.getCilindrada());

        return motoRepository.save(moto);
    }
}