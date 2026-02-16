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

    // Cadastrar viagem
    public Trip create(Trip trip) {
        return repository.save(trip);
    }

    // Atualizar viagem
    public Trip update(Long id, Trip updatedTripData) {
        // 1. Busca a viagem existente ou lança erro
        Trip existingTrip = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found with ID: " + id));

        // 2. Atualiza os campos (supondo que sua Entity já esteja em inglês conforme você pediu)
        // Se sua Entity ainda estiver com nomes em português, ajuste os get/set abaixo
        existingTrip.setOrigin(updatedTripData.getOrigin());
        existingTrip.setDestination(updatedTripData.getDestination());
        existingTrip.setDepartureTime(updatedTripData.getDepartureTime());
        existingTrip.setType(updatedTripData.getType());

        // 3. Salva a alteração
        return repository.save(existingTrip);
    }
    
    // Listar todas as viagens
    public List<Trip> listAll() {
        return repository.findAll();
    }

    // buscar por ID
    public Trip searchById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Viagem não encontrada"));
    }
}
