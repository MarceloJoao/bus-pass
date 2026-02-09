package io.transportproject.Transport.controller;

import io.transportproject.Transport.entity.User;
import io.transportproject.Transport.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    // POST - cadastrar usuário
    @PostMapping
    public ResponseEntity<User> cadastrar(@RequestBody User user) {
        return ResponseEntity.ok(service.cadastrar(user));
    }

    // GET - listar usuários
    @GetMapping
    public ResponseEntity<List<User>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    // GET - buscar usuário por id
    @GetMapping("/{id}")
    public ResponseEntity<User> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
}
