package io.transportproject.Transport.controller;

import io.transportproject.Transport.dto.request.CreateTicketRequest;
import io.transportproject.Transport.dto.response.TicketResponse;
import io.transportproject.Transport.service.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService service;

    // Criar nova passagem
    @PostMapping
    public ResponseEntity<TicketResponse> create(
            @Valid @RequestBody CreateTicketRequest request
    ) {

        TicketResponse response = service.buy(request);

        return ResponseEntity
                .status(HttpStatus.CREATED) // 201
                .body(response);
    }

    // Listar passagens
    @GetMapping
    public ResponseEntity<List<TicketResponse>> list() {
        return ResponseEntity.ok(service.listAll());
    }
}