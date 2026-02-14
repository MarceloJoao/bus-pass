package io.transportproject.Transport.controller;

import io.transportproject.Transport.entity.User;
import io.transportproject.Transport.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    // POST - cadastrar usuário
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.ok(service.create(user));
    }

    // GET - listar usuários
    @GetMapping
    public ResponseEntity<List<User>> list() {
        return ResponseEntity.ok(service.listAll());
    }

    // GET - buscar usuário por id
    @GetMapping("/{id}")
    public ResponseEntity<User> search(@PathVariable Long id) {
        return ResponseEntity.ok(service.searchById(id));
    }
}
