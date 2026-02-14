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

    // Cadastrar usuário
    public User create(User user) {
        return repository.save(user);
    }

    // Listar todos os usuários
    public List<User> listAll() {
        return repository.findAll();
    }

    // Buscar usuário por ID
    public User searchById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}
