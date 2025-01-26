package com.ajucar.request;

import com.ajucar.enums.TipoVeiculo;
import jakarta.validation.constraints.*;

public class VeiculoRequest {

    @NotBlank(message = "O modelo é obrigatório")
    private String modelo;

    @NotBlank(message = "O fabricante é obrigatório")
    private String fabricante;

    private String cor;

    @NotNull(message = "O ano é obrigatório")
    @Min(value = 1900, message = "O ano deve ser maior ou igual a 1900")
    @Max(value = 2100, message = "O ano deve ser menor ou igual a 2100")
    private Integer ano;

    @NotNull(message = "O preço é obrigatório")
    @Positive(message = "O preço deve ser maior que zero")
    private Double preco;

    private Integer quantidadePortas;
    private String tipoCombustivel;
    private Integer cilindrada;

    @NotNull(message = "O tipo de veículo é obrigatório")
    private TipoVeiculo tipoVeiculo;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
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

    public Integer getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(Integer cilindrada) {
        this.cilindrada = cilindrada;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}