package io.transportproject.Transport.controller;

import io.transportproject.Transport.entity.Ticket;
import io.transportproject.Transport.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService service;

    // Comprar passagem
    @PostMapping("/buy")
    public ResponseEntity<Ticket> buy(
            @RequestParam Long userId,
            @RequestParam Long tripId,
            @RequestParam Integer seatNumber
    ) {
        return ResponseEntity.ok(
                service.buy(userId, tripId, seatNumber)
        );
    }

    // listar passagens
    @GetMapping
    public ResponseEntity<List<Ticket>> list() {
        return ResponseEntity.ok(service.listAll());
    }
}
