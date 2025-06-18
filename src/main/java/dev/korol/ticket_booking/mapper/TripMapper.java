package dev.korol.ticket_booking.mapper;

import dev.korol.ticket_booking.dto.TripCreateDTO;
import dev.korol.ticket_booking.dto.TripDTO;
import dev.korol.ticket_booking.entity.Trip;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TripMapper {

    Trip toTrip(TripDTO tripDTO);

    @Mapping(source = "transportType", target = "transportType")
    Trip toTrip(TripCreateDTO tripCreateDTO);

    @Mapping(source = "transportType", target = "transportType")
    TripDTO toTripDTO(Trip trip);

}
