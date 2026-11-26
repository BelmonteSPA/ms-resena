package com.belmonte.ms_resena.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViajeDTO {

    private Long id;
    private Long idPasajero;
    private Long idConductor;
    private String estado;
}