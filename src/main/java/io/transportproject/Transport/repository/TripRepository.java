package io.transportproject.Transport.repository;

import io.transportproject.Transport.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
}
