package dev.korol.ticket_booking.repository;

import dev.korol.ticket_booking.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByUserId(Long userId);
    List<Ticket> findByTripId(Long tripId);

}
