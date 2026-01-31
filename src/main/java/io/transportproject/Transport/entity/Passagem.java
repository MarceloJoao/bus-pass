package io.transportproject.Transport.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "passagens")
@Data
public class Passagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Usuário que comprou
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private User usuario;

    // Viagem comprada
    @ManyToOne
    @JoinColumn(name = "viagem_id", nullable = false)
    private Trip viagem;

    @Column(nullable = false)
    private Integer numeroAssento;

    @Column(nullable = false)
    private Boolean pago;
}
