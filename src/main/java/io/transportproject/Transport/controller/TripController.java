package io.transportproject.Transport.controller;

import io.transportproject.Transport.entity.Trip;
import io.transportproject.Transport.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("viagens")
@RequiredArgsConstructor
public class TripController {

    private final TripService service;

    
    @PostMapping
    public ResponseEntity<Trip> cadastrar(@RequestBody Trip trip) {
        return ResponseEntity.ok(service.cadastrar(trip));
    }


    @GetMapping
    public ResponseEntity<List<Trip>> listar() {
        return ResponseEntity.ok(service.listarTodas());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Trip> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
}
