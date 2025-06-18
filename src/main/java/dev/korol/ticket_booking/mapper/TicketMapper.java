package dev.korol.ticket_booking.mapper;

import dev.korol.ticket_booking.dto.TicketCreateDTO;
import dev.korol.ticket_booking.dto.TicketDTO;
import dev.korol.ticket_booking.entity.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TicketMapper {

    Ticket toTicket(TicketDTO ticketDTO);

    @Mapping(source = "tripId", target = "trip.id")
    @Mapping(source = "seatType" , target = "seatType")
    Ticket toTicket(TicketCreateDTO ticketCreateDTO);

    @Mapping(source = "trip.id" , target = "tripId" )
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "seatType" , target = "seatType")
    TicketDTO toTicketDTO(Ticket ticket);


}
