package com.ajucar.service;

import com.ajucar.entity.Carro;
import com.ajucar.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> findAll() {
        return this.carroRepository.findAll();
    }

    public Carro save(Carro carro) {
        return this.carroRepository.save(carro);
    }
}