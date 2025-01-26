package com.ajucar.enums;

public enum TipoVeiculo {
    CARRO(0),
    MOTO(1);

    private final int id;

    TipoVeiculo(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static TipoVeiculo fromId(int id) {
        for (TipoVeiculo tipo : TipoVeiculo.values()) {
            if (tipo.getId() == id) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("ID inválido: " + id);
    }
}