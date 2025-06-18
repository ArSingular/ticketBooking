package dev.korol.ticket_booking.service.impl;

import dev.korol.ticket_booking.dto.TicketCreateDTO;
import dev.korol.ticket_booking.dto.TicketDTO;
import dev.korol.ticket_booking.entity.Ticket;
import dev.korol.ticket_booking.entity.enums.TicketStatus;
import dev.korol.ticket_booking.entity.Trip;
import dev.korol.ticket_booking.entity.User;
import dev.korol.ticket_booking.exception.BadRequestException;
import dev.korol.ticket_booking.exception.NotFoundException;
import dev.korol.ticket_booking.mapper.TicketMapper;
import dev.korol.ticket_booking.repository.TicketRepository;
import dev.korol.ticket_booking.repository.TripRepository;
import dev.korol.ticket_booking.repository.UserRepository;
import dev.korol.ticket_booking.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {


    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final TripRepository tripRepository;
    private final TicketMapper ticketMapper = Mappers.getMapper(TicketMapper.class);

    @Override
    public TicketDTO createTicket(TicketCreateDTO ticketCreateDTO) {
        Ticket ticket = ticketMapper.toTicket(ticketCreateDTO);
        Trip trip = tripRepository.findById(ticketCreateDTO.getTripId())
                .orElseThrow(() -> new NotFoundException("Trip with ID: " + ticketCreateDTO.getTripId() +  " not found"));

        ticket.setUser(null);
        ticket.setStatus(TicketStatus.AVAILABLE);
        ticket.setPurchaseTime(null);
        ticket.setTrip(trip);

        Ticket saved = ticketRepository.save(ticket);

        return ticketMapper.toTicketDTO(saved);
    }

    @Override
    public TicketDTO purchaseTicket(Long ticketId, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User with ID: " +userId +  " not found"));

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new NotFoundException("Ticket with ID: " +ticketId +  " not found"));

        if(ticket.getStatus() != TicketStatus.AVAILABLE){
                throw new BadRequestException("Ticket is not available for purchase");
        }

        ticket.setUser(user);
        ticket.setPurchaseTime(LocalDateTime.now());
        ticket.setStatus(TicketStatus.BOOKED);

        Ticket saved = ticketRepository.save(ticket);

        return ticketMapper.toTicketDTO(saved);
    }

    @Override
    public TicketDTO getTicketById(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new NotFoundException("Ticket with ID: " + ticketId +  " not found"));

        return ticketMapper.toTicketDTO(ticket);
    }

    @Override
    public TicketDTO updateTicket(Long ticketId, TicketCreateDTO ticketCreateDTO) {
        Ticket existing = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new NotFoundException("Ticket with ID: " + ticketId +  " not found"));
        Trip trip = tripRepository.findById(ticketCreateDTO.getTripId())
                .orElseThrow(() -> new NotFoundException("Trip with ID: " + ticketCreateDTO.getTripId() +  " not found"));

        existing.setSeatNumber(ticketCreateDTO.getSeatNumber());
        existing.setPrice(ticketCreateDTO.getPrice());
        existing.setTrip(trip);

        Ticket saved = ticketRepository.save(existing);

        return ticketMapper.toTicketDTO(saved);
    }

    @Override
    public List<TicketDTO> getAllTickets() {
        return ticketRepository.findAll()
                .stream().map(ticketMapper::toTicketDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TicketDTO> getAllUserTickets(Long userId) {

        return ticketRepository.findByUserId(userId)
                .stream().map(ticketMapper::toTicketDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new NotFoundException("Ticket with ID: " + ticketId +  " not found"));
        ticketRepository.delete(ticket);
    }
}
