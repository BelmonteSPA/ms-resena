package com.belmonte.ms_resena.controller;

import com.belmonte.ms_resena.dto.ResenaDTO;
import com.belmonte.ms_resena.service.ResenaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reseñas")
@RequiredArgsConstructor
public class ResenaController {

    private final ResenaService resenaService;

    @PostMapping
    public ResponseEntity<ResenaDTO> crearResena(@Valid @RequestBody ResenaDTO dto) {
        ResenaDTO nuevaResena = resenaService.crearResena(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaResena);
    }


    @GetMapping("/evaluado/{idEvaluado}/promedio")
    public ResponseEntity<Double> obtenerPromedioCalificacion(@PathVariable Long idEvaluado) {
        Double promedio = resenaService.obtenerPromedioCalificacion(idEvaluado);
        return ResponseEntity.ok(promedio);
    }
}
