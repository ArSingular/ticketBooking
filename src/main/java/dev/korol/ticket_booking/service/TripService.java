package dev.korol.ticket_booking.service;

import dev.korol.ticket_booking.dto.TripCreateDTO;
import dev.korol.ticket_booking.dto.TripDTO;

import java.util.List;

public interface TripService {

    TripDTO createTrip(TripCreateDTO tripCreateDTO);
    TripDTO getTripById(Long tripId);
    TripDTO updateTrip(Long tripId, TripCreateDTO tripCreateDTO);
    List<TripDTO> getAllTrips();
    void deleteTrip(Long tripId);

}
