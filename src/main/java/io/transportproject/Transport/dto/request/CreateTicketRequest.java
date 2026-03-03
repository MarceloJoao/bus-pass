package io.transportproject.Transport.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateTicketRequest {

    @NotNull
    private Long userId;

    @NotNull
    private Long tripId;

    @NotNull
    private Integer seatNumber;
}