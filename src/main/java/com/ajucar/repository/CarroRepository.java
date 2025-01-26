package com.ajucar.repository;

import com.ajucar.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
    @Query(
            value = "SELECT c.*, v.modelo, v.fabricante, v.ano, v.preco, v.tipo_veiculo, v.cor " +
                    "FROM carro c " +
                    "INNER JOIN veiculo v ON c.id = v.id " +
                    "WHERE c.id = :id",
            nativeQuery = true
    )
    Carro findCarroById(@Param("id") Long id);
}