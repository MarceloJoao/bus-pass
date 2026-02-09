package io.transportproject.Transport.controller;

import io.transportproject.Transport.entity.Documento;
import io.transportproject.Transport.service.DocumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documentos")
@RequiredArgsConstructor
public class DocumentoController {

    private final DocumentoService service;

    @PostMapping("/usuario/{userId}")
    public Documento criar(@PathVariable Long userId,
                           @RequestBody Documento documento) {
        return service.criar(userId, documento);
    }

    @GetMapping("/usuario/{userId}")
    public List<Documento> listar(@PathVariable Long userId) {
        return service.listarPorUsuario(userId);
    }

    @PutMapping("/{id}/aprovar")
    public Documento aprovar(@PathVariable Long id) {
        return service.aprovar(id);
    }

    @PutMapping("/{id}/rejeitar")
    public Documento rejeitar(@PathVariable Long id) {
        return service.rejeitar(id);
    }
}
