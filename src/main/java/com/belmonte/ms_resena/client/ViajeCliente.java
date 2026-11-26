package com.belmonte.ms_resena.client;

import com.belmonte.ms_resena.dto.ViajeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Con Eureka activo, "clients.viajes.url" se deja vacio y se resuelve por el nombre ms-viajes
@FeignClient(name = "ms-viajes", url = "${clients.viajes.url:}")
public interface ViajeCliente {

    @GetMapping("/api/v1/viajes/{idViaje}")
    ViajeDTO obtenerViajePorId(@PathVariable("idViaje") Long idViaje);
}
