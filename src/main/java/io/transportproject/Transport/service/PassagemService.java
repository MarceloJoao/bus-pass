package io.transportproject.Transport.service;

import io.transportproject.Transport.entity.Passagem;
import io.transportproject.Transport.entity.Trip;
import io.transportproject.Transport.entity.User;
import io.transportproject.Transport.repository.PassagemRepository;
import io.transportproject.Transport.repository.TripRepository;
import io.transportproject.Transport.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassagemService {

    private final PassagemRepository passagemRepository;
    private final UserRepository userRepository;
    private final TripRepository tripRepository;

    // comprar passagem
    public Passagem comprar(Long userId, Long tripId, Integer numeroAssento) {

        User usuario = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Trip viagem = tripRepository.findById(tripId)
                .orElseThrow(() -> new RuntimeException("Viagem não encontrada"));

        // verificar se assento já foi vendido
        boolean assentoOcupado = passagemRepository
                .findByViagemIdAndNumeroAssento(tripId, numeroAssento)
                .isPresent();

        if (assentoOcupado) {
            throw new RuntimeException("Assento já ocupado");
        }

        Passagem passagem = new Passagem();
        passagem.setUsuario(usuario);
        passagem.setViagem(viagem);
        passagem.setNumeroAssento(numeroAssento);
        passagem.setPago(true);

        return passagemRepository.save(passagem);
    }

    // listar todas
    public List<Passagem> listarTodas() {
        return passagemRepository.findAll();
    }
}
