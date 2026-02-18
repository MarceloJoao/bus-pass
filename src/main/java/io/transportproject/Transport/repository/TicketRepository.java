package io.transportproject.Transport.repository;

import io.transportproject.Transport.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Optional<Ticket> findByTripIdAndSeatNumber(Long tripId, Integer seatNumber);
}
