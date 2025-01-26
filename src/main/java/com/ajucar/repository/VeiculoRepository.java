package com.ajucar.repository;

import com.ajucar.entity.Veiculo;
import com.ajucar.enums.TipoVeiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    @Query("SELECT v, c, m " +
            "FROM Veiculo v " +
            "LEFT JOIN Carro c ON v.id = c.id " +
            "LEFT JOIN Moto m ON v.id = m.id WHERE v.id = :id")
    Veiculo findVeiculoById(Long id);

    @Query("SELECT v FROM Veiculo v WHERE LOWER(v.modelo) LIKE LOWER(CONCAT('%', :modelo, '%'))")
    List<Veiculo> findByModelo(@Param("modelo") String modelo);

    @Query("SELECT v FROM Veiculo v WHERE LOWER(v.fabricante) LIKE LOWER(CONCAT('%', :fabricante, '%'))")
    List<Veiculo> findByFabricante(@Param("fabricante") String fabricante);

    @Query("SELECT v FROM Veiculo v WHERE LOWER(v.cor) LIKE LOWER(CONCAT('%', :cor, '%'))")
    List<Veiculo> findByCor(@Param("cor") String cor);

    List<Veiculo> findByAno(@Param("ano") Integer ano);

    @Query("SELECT v FROM Veiculo v WHERE v.tipoVeiculo = :tipoVeiculo")
    List<Veiculo> findByTipoVeiculo(@Param("tipoVeiculo") TipoVeiculo tipoVeiculo);
}