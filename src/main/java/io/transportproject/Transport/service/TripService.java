package io.transportproject.Transport.service;

import io.transportproject.Transport.entity.Trip;
import io.transportproject.Transport.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository repository;

    // cadastrar viagem
    public Trip cadastrar(Trip trip) {
        return repository.save(trip);
    }

    // listar todas as viagens
    public List<Trip> listarTodas() {
        return repository.findAll();
    }

    // buscar por ID
    public Trip buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Viagem não encontrada"));
    }
}
