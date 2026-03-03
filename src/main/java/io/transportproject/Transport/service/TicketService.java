package io.transportproject.Transport.service;

import io.transportproject.Transport.dto.request.CreateTicketRequest;
import io.transportproject.Transport.dto.response.TicketResponse;
import io.transportproject.Transport.entity.Ticket;
import io.transportproject.Transport.entity.User;
import io.transportproject.Transport.entity.Trip;
import io.transportproject.Transport.repository.TicketRepository;
import io.transportproject.Transport.repository.UserRepository;
import io.transportproject.Transport.repository.TripRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final TripRepository tripRepository;

    @Transactional
    public TicketResponse buy(CreateTicketRequest request) {

        // 1️⃣ Buscar usuário
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // 2️⃣ Buscar viagem
        Trip trip = tripRepository.findById(request.getTripId())
                .orElseThrow(() -> new RuntimeException("Viagem não encontrada"));

        // 3️⃣ Verificar se assento já está ocupado
        boolean seatExists = ticketRepository
                .existsByTripIdAndSeatNumber(
                        request.getTripId(),
                        request.getSeatNumber()
                );

        if (seatExists) {
            throw new RuntimeException("Assento já está ocupado");
        }

        // 4️⃣ Criar entidade Ticket
        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setTrip(trip);
        ticket.setSeatNumber(request.getSeatNumber());

        // 5️⃣ Salvar no banco
        Ticket savedTicket = ticketRepository.save(ticket);

        // 6️⃣ Converter Entity → Response DTO
        return TicketResponse.builder()
                .id(savedTicket.getId())
                .userId(savedTicket.getUser().getId())
                .tripId(savedTicket.getTrip().getId())
                .seatNumber(savedTicket.getSeatNumber())
                .build();
    }

    public List<TicketResponse> listAll() {

        return ticketRepository.findAll()
                .stream() // transforma lista em stream
                .map(ticket -> TicketResponse.builder()
                        .id(ticket.getId())
                        .userId(ticket.getUser().getId())
                        .tripId(ticket.getTrip().getId())
                        .seatNumber(ticket.getSeatNumber())
                        .build()
                )
                .collect(Collectors.toList()); // volta para lista
    }
}