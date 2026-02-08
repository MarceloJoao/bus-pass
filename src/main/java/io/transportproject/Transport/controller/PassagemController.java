package io.transportproject.Transport.controller;

import io.transportproject.Transport.entity.Passagem;
import io.transportproject.Transport.service.PassagemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passagens")
@RequiredArgsConstructor
public class PassagemController {

    private final PassagemService service;

    // comprar passagem
    @PostMapping("/comprar")
    public ResponseEntity<Passagem> comprar(
            @RequestParam Long userId,
            @RequestParam Long tripId,
            @RequestParam Integer numeroAssento
    ) {
        return ResponseEntity.ok(
                service.comprar(userId, tripId, numeroAssento)
        );
    }

    // listar passagens
    @GetMapping
    public ResponseEntity<List<Passagem>> listar() {
        return ResponseEntity.ok(service.listarTodas());
    }
}
