package com.ajucar.entity;

import com.ajucar.enums.TipoVeiculo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Carro extends Veiculo {

    @Column(nullable = false, name = "quantidade_portas")
    private Integer quantidadePortas;

    @Column(nullable = false, name = "tipo_combustivel")
    private String tipoCombustivel;

    public Carro() {
        this.setTipoVeiculo(TipoVeiculo.CARRO);
    }

    public Integer getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(Integer quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }
}