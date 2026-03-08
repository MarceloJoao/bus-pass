package io.transportproject.Transport.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TripResponse {

    private Long id;
    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private Integer availableSeats;
}