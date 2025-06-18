package dev.korol.ticket_booking.dto;

import dev.korol.ticket_booking.entity.enums.TransportType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TripDTO {

    private Long id;
    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private TransportType transportType;


}
