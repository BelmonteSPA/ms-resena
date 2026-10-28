package com.belmonte.ms_resena.service;

import com.belmonte.ms_resena.dto.ResenaDTO;
import com.belmonte.ms_resena.modulo.Resena;
import com.belmonte.ms_resena.repository.ResenaRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Builder
public class ResenaService {

    private final ResenaRepository resenaRepository;

    @Transactional
    public ResenaDTO crearResena(ResenaDTO dto) {
        Resena resena = Resena.builder()
                .idViaje(dto.getIdViaje())
                .idEvaluador(dto.getIdEvaluador())
                .idEvaluado(dto.getIdEvaluado())
                .calificacion(dto.getCalificacion())
                .comentario(dto.getComentario())
                .build();

        Resena guardada = resenaRepository.save(resena);
        return convertirADto(guardada);
    }
    @Transactional(readOnly = true)
    public Double obtenerPromedioCalificacion(Long idEvaluado) {
        Double promedio = resenaRepository.obtenerPromedioCalificacion(idEvaluado);
        return promedio != null ? promedio : 0.0;
    }

    private ResenaDTO convertirADto(Resena entity) {
        return ResenaDTO.builder()
                .idResena(entity.getIdResena())
                .idViaje(entity.getIdViaje())
                .idEvaluador(entity.getIdEvaluador())
                .idEvaluado(entity.getIdEvaluador())
                .calificacion(entity.getCalificacion())
                .comentario(entity.getComentario())
                .fechaCreacion(entity.getFechaCreacion())
                .build();
    }


}
