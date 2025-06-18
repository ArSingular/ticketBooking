package dev.korol.ticket_booking.dto;

import dev.korol.ticket_booking.entity.enums.SeatType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TicketCreateDTO {

    @NotBlank(message = "Seat number is required")
    private String seatNumber;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private BigDecimal price;

    @NotNull(message = "Trip ID is required")
    private Long tripId;

    @NotNull(message = "Seat type is required")
    private SeatType seatType;

}
