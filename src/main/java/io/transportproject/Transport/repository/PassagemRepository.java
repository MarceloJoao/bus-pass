package io.transportproject.Transport.repository;

import io.transportproject.Transport.entity.Passagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PassagemRepository extends JpaRepository<Passagem, Long> {

    Optional<Passagem> findByViagemIdAndNumeroAssento(Long viagemId, Integer numeroAssento);
}
