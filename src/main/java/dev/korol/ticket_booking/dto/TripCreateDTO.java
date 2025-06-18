package dev.korol.ticket_booking.dto;

import dev.korol.ticket_booking.entity.enums.TransportType;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TripCreateDTO {

    @NotBlank(message = "Origin is required")
    private String origin;

    @NotBlank(message = "Destination is required")
    private String destination;

    @Future(message = "Departure time must be in the future")
    private LocalDateTime departureTime;

    @Future(message = "Arrival time must be in the future")
    private LocalDateTime arrivalTime;

    @NotNull(message = "Transport is required")
    @NotBlank(message = "Transport is required")
    private TransportType transportType;

}
