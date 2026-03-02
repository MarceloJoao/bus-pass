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
    public Document create(@PathVariable Long userId,
                           @RequestBody Document documento) {
        return service.create(userId, documento);
    }

    @GetMapping("/user/{userId}")
    public List<Document> list(@PathVariable Long userId) {
        return service.listByUser(userId);
    }

    @PutMapping("/{id}/approve")
    public Document approve(@PathVariable Long id) {
        return service.approve(id);
    }

    @PutMapping("/{id}/reject")
    public Document reject(@PathVariable Long id) {
        return service.reject(id);
    }

    @PutMapping("/{id}")
    public Document update(@PathVariable Long id, @RequestBody Document documento) {
        return service.update(id, documento);
    }

    @DeleteMapping("/{id}")
    public Document delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
