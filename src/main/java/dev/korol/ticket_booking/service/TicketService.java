package dev.korol.ticket_booking.service;

import dev.korol.ticket_booking.dto.TicketCreateDTO;
import dev.korol.ticket_booking.dto.TicketDTO;

import java.util.List;

public interface TicketService {

    TicketDTO createTicket(TicketCreateDTO ticketCreateDTO);
    TicketDTO purchaseTicket(Long ticketId, Long userId);
    TicketDTO getTicketById(Long ticketId);
    TicketDTO updateTicket(Long ticketId, TicketCreateDTO ticketCreateDTO);
    List<TicketDTO> getAllTickets();
    List<TicketDTO> getAllUserTickets(Long userId);
    void deleteTicket(Long ticketId);


}
