package com.belmonte.ms_resena.client;

import com.belmonte.ms_resena.dto.ViajeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-viaje", path = "/api/viajes")
public interface ViajeCliente {

    @GetMapping("/{idViaje}")
    ViajeDTO obtenerViajePorId(@PathVariable("idViaje") Long idViaje);
}
