package com.belmonte.ms_resena.repository;

import com.belmonte.ms_resena.modulo.Resena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResenaRepository extends JpaRepository<Resena, Long> {

    //los nombres deben coincidir con los atributos de Resena (idEvaluado, idViaje)
    List<Resena> findByIdEvaluadoOrderByFechaCreacionDesc(Long idEvaluado);

    List<Resena> findByIdViaje(Long idViaje);

    @Query("SELECT AVG(r.calificacion) FROM Resena r WHERE r.idEvaluado = :idEvaluado")
    Double obtenerPromedioCalificacion(@Param("idEvaluado") Long idEvaluado);
}