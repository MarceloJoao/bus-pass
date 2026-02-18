package io.transportproject.Transport.controller;

import io.transportproject.Transport.entity.Document;
import io.transportproject.Transport.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService service;

    @PostMapping("/user/{userId}")
    public Document criar(@PathVariable Long userId,
                           @RequestBody Document documento) {
        return service.criar(userId, documento);
    }

    @GetMapping("/user/{userId}")
    public List<Document> list(@PathVariable Long userId) {
        return service.listByUser(userId);
    }

    @PutMapping("/{id}/aprove")
    public Document aprove(@PathVariable Long id) {
        return service.aprove(id);
    }

    @PutMapping("/{id}/reject")
    public Document reject(@PathVariable Long id) {
        return service.reject(id);
    }
}
