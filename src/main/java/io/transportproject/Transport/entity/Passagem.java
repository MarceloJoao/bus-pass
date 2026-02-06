package io.transportproject.Transport.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(
    name = "passagens",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"viagem_id", "numero_assento"})
    }
)
@Data
public class Passagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Usuário que comprou a passagem
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private User usuario;

    // Viagem associada
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "viagem_id", nullable = false)
    private Trip viagem;

    // Número do assento
    @Column(name = "numero_assento", nullable = false)
    private Integer numeroAssento;

    // Se já foi pago
    @Column(nullable = false)
    private Boolean pago = false;
}
