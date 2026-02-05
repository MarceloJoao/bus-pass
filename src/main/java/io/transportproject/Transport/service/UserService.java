package io.transportproject.Transport.service;

import io.transportproject.Transport.entity.User;
import io.transportproject.Transport.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    // cadastrar usuário
    public User cadastrar(User user) {
        return repository.save(user);
    }

    // listar todos os usuários
    public List<User> listarTodos() {
        return repository.findAll();
    }

    // buscar usuário por ID
    public User buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}
