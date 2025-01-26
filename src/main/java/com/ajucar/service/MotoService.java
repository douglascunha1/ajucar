package com.ajucar.service;

import com.ajucar.entity.Moto;
import com.ajucar.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService {
    @Autowired
    private MotoRepository motoRepository;

    public List<Moto> findAll() {
        return this.motoRepository.findAll();
    }

    public Moto save(Moto moto) {
        return this.motoRepository.save(moto);
    }
}
