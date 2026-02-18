package io.transportproject.Transport.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(
    name = "tickets",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"trip_id", "seat_number"})
    }
)
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Usuário que comprou a passagem
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Viagem associada
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    // Número do assento
    @Column(name = "seat_number", nullable = false)
    private Integer seatNumber;

    // Se já foi pago
    @Column(nullable = false)
    private Boolean paid = false;
}
