package io.transportproject.Transport.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "documentos")
@Data
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Usuário dono do documento
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private User usuario;

    @Column(nullable = false)
    private String nomeArquivo;

    // caminho ou URL do PDF
    @Column(nullable = false)
    private String urlArquivo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusDocumento status;
}
