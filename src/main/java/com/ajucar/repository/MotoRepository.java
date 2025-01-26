package com.ajucar.repository;

import com.ajucar.entity.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {
    @Query(
            value = "SELECT m.*, v.modelo, v.fabricante, v.ano, v.preco, v.tipo_veiculo, v.cor " +
                    "FROM moto m " +
                    "INNER JOIN veiculo v ON m.id = v.id " +
                    "WHERE m.id = :id",
            nativeQuery = true
    )
    Moto findMotoById(@Param("id") Long id);
}