package com.ajucar.repository;

import com.ajucar.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    @Query("SELECT v, c, m " +
            "FROM Veiculo v " +
            "LEFT JOIN Carro c ON v.id = c.id " +
            "LEFT JOIN Moto m ON v.id = m.id WHERE v.id = :id")
    Veiculo findVeiculoById(Long id);
}