package com.ajucar.service;

import com.ajucar.entity.Veiculo;
import com.ajucar.enums.TipoVeiculo;
import com.ajucar.repository.CarroRepository;
import com.ajucar.repository.MotoRepository;
import com.ajucar.repository.VeiculoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private MotoRepository motoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> findAllVeiculos(Integer tipoVeiculo, String cor, String modelo, String fabricante, Integer ano) {
        List<Veiculo> veiculos = new ArrayList<>();

        if (tipoVeiculo != null) {
            TipoVeiculo tipo = TipoVeiculo.fromId(tipoVeiculo);
            veiculos.addAll(veiculoRepository.findByTipoVeiculo(tipo));
        } else {
            veiculos.addAll(veiculoRepository.findAll());
        }

        if (cor != null && !cor.trim().isEmpty()) {
            veiculos = veiculos.stream()
                    .filter(v -> veiculoRepository.findByCor(cor).contains(v))
                    .collect(Collectors.toList());
        }

        if (modelo != null && !modelo.trim().isEmpty()) {
            veiculos = veiculos.stream()
                    .filter(v -> veiculoRepository.findByModelo(modelo).contains(v))
                    .collect(Collectors.toList());
        }

        if(fabricante != null && !fabricante.trim().isEmpty()) {
            veiculos = veiculos.stream()
                    .filter(v -> veiculoRepository.findByFabricante(fabricante).contains(v))
                    .collect(Collectors.toList());
        }

        if (ano != null && ano > 0) {
            veiculos = veiculos.stream()
                    .filter(v -> v.getAno().equals(ano))
                    .collect(Collectors.toList());
        }

        return veiculos;
    }

    public Veiculo findVeiculoById(Long id) {
        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);

        if (veiculoOptional.isPresent()) {
            Veiculo veiculo = veiculoOptional.get();
            if (veiculo.getTipoVeiculo() == TipoVeiculo.CARRO) {
                return veiculoRepository.findById(id).
                        orElseThrow(() -> new EntityNotFoundException("Veículo não encontrado com o ID: " + id));
            } else if (veiculo.getTipoVeiculo() == TipoVeiculo.MOTO) {
                return veiculoRepository.findById(id).
                        orElseThrow(() -> new EntityNotFoundException("Veículo não encontrado com o ID: " + id));
            }
        }
        throw new EntityNotFoundException("Veículo não encontrado com o ID: " + id);
    }

    public void deleteVeiculoById(Long id) {
        Optional<Veiculo> veiculoOptional = veiculoRepository.findById(id);

        if (veiculoOptional.isPresent()) {
            Veiculo veiculo = veiculoOptional.get();
            if (veiculo.getTipoVeiculo() == TipoVeiculo.CARRO) {
                carroRepository.deleteById(id);
            } else if (veiculo.getTipoVeiculo() == TipoVeiculo.MOTO) {
                motoRepository.deleteById(id);
            }
            veiculoRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Veículo não encontrado com o ID: " + id);
        }
    }
}