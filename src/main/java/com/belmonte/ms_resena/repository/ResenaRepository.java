package com.belmonte.ms_resena.repository;

import com.belmonte.ms_resena.modulo.Resena;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface ResenaRepository extends JpaRepository<Resena, Long> {

    List<Resena> findByEvaluadoIdOrderByFechaCreacionDesc(Long idEvaluado);

    List<Resena> findByViajeId(Long idViaje);

    @Query("SELECT AVG(r.calificacion) FROM Resena r WHERE r.evaluadoId = :idEvaluado")
    Double obtenerPromedioCalificacion(@Param("id_evaluado") Long idEvaluado);

    @Query("SELECT AVG(r.calificacion) FROM Resena r WHERE r.idEvaluado = :idEvaluado")
    Double obtenerResenasPorEvaluado(@Param("id_evaluado") Long idEvaluado);
}
