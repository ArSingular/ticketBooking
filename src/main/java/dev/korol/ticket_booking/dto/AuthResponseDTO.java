package dev.korol.ticket_booking.dto;

import lombok.Builder;

@Builder
public record AuthResponseDTO(String token) {
}
