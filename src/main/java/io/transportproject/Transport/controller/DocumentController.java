package io.transportproject.Transport.controller;

import io.transportproject.Transport.dto.request.CreateDocumentRequest;
import io.transportproject.Transport.dto.response.DocumentResponse;
import io.transportproject.Transport.service.DocumentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService service;

    // criar documento para usuário
    @PostMapping("/user/{userId}")
    public DocumentResponse create(
            @PathVariable Long userId,
            @Valid @RequestBody CreateDocumentRequest request
    ) {
        return service.create(userId, request);
    }

    // listar documentos do usuário
    @GetMapping("/user/{userId}")
    public List<DocumentResponse> list(@PathVariable Long userId) {
        return service.listByUser(userId);
    }

    @GetMapping("/pending")
    public List<DocumentResponse> listPending() {
        return service.listPending();
    }

    // aprovar documento
    @PutMapping("/{id}/approve")
    public DocumentResponse approve(@PathVariable Long id) {
        return service.approve(id);
    }

    // rejeitar documento
    @PutMapping("/{id}/reject")
    public DocumentResponse reject(@PathVariable Long id) {
        return service.reject(id);
    }

    // atualizar documento
    @PutMapping("/{id}")
    public DocumentResponse update(
            @PathVariable Long id,
            @Valid @RequestBody CreateDocumentRequest request
    ) {
        return service.update(id, request);
    }

    // deletar documento
    @DeleteMapping("/{id}")
    public DocumentResponse delete(@PathVariable Long id) {
        return service.delete(id);
    }
}