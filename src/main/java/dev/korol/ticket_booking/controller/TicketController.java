package dev.korol.ticket_booking.controller;

import dev.korol.ticket_booking.dto.TicketCreateDTO;
import dev.korol.ticket_booking.dto.TicketDTO;
import dev.korol.ticket_booking.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketDTO> createTicket(@RequestBody TicketCreateDTO ticketCreateDTO){
        TicketDTO ticket = ticketService.createTicket(ticketCreateDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(ticket);
    }

    @PostMapping("/{ticketId}/purchase")
    public ResponseEntity<TicketDTO> purchaseTicket(@PathVariable Long ticketId, @RequestParam Long userId){

        TicketDTO ticketDTO = ticketService.purchaseTicket(ticketId, userId);

        return ResponseEntity.ok(ticketDTO);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TicketDTO>> getUserTickets(@PathVariable Long userId) {
        List<TicketDTO> tickets = ticketService.getAllUserTickets(userId);
        return ResponseEntity.ok(tickets);
    }

    @GetMapping()
    public ResponseEntity<List<TicketDTO>> getAllTickets(){
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    @DeleteMapping("/{ticketId}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long ticketId){
        ticketService.deleteTicket(ticketId);
        return ResponseEntity.noContent().build();
    }

}
