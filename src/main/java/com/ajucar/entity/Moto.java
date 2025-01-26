package com.ajucar.entity;

import com.ajucar.enums.TipoVeiculo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Moto extends Veiculo {

    @Column(nullable = false)
    private Integer cilindrada;

    public Moto() {
        this.setTipoVeiculo(TipoVeiculo.MOTO);
    }

    public Integer getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(Integer cilindrada) {
        this.cilindrada = cilindrada;
    }
}