package io.transportproject.Transport.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketResponse {

    private Long id;
    private Long userId;
    private Long tripId;
    private Integer seatNumber;
}