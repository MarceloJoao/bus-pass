package io.transportproject.Transport.service;

import io.transportproject.Transport.entity.Ticket;
import io.transportproject.Transport.entity.Trip;
import io.transportproject.Transport.entity.User;
import io.transportproject.Transport.repository.TicketRepository;
import io.transportproject.Transport.repository.TripRepository;
import io.transportproject.Transport.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final TripRepository tripRepository;

    // Comprar passagem
    public Ticket buy(Long userId, Long tripId, Integer seatNumber) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new RuntimeException("Viagem não encontrada"));

        // Verificar se assento já foi vendido
        boolean seatOccupied = ticketRepository
                .findByTripIdAndSeatNumber(tripId, seatNumber)
                .isPresent();

        if (seatOccupied) {
            throw new RuntimeException("Assento já ocupado");
        }

        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setTrip(trip);
        ticket.setSeatNumber(seatNumber);
        ticket.setPaid(true);

        return ticketRepository.save(ticket);
    }

    // Listar todas
    public List<Ticket> listAll() {
        return ticketRepository.findAll();
    }
}
