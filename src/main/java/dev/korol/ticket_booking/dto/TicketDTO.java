package dev.korol.ticket_booking.dto;

import dev.korol.ticket_booking.entity.enums.SeatType;
import dev.korol.ticket_booking.entity.enums.TicketStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TicketDTO {

    private Long id;
    private String seatNumber;
    private TicketStatus status;
    private BigDecimal price;
    private LocalDateTime purchaseTime;
    private Long tripId;
    private Long userId;
    private SeatType seatType;

}
