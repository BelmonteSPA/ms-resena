package com.belmonte.ms_resena.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ResenaDTO {

    private Long idResena;

    @NotNull(message = "El ID del viaje es obligatorio")
    private Long idViaje;

    @NotNull(message = "El ID del evaluador es obligatorio")
    private Long idEvaluador;

    @NotNull(message = "El ID del evaluado es obligatorio")
    private Long idEvaluado;

    @NotNull(message = "La calificación es obligatoria")
    @Min(value = 1, message = "La calificación mínima es 1 estrella")
    @Max(value = 5, message = "La calificación máxima es 5 estrellas")
    private Integer calificacion;

    @Size(max = 500, message = "El comentario no puede superar los 500 caracteres")
    private String comentario;

    private LocalDateTime fechaCreacion;

}
