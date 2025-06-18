package dev.korol.ticket_booking.service.impl;

import dev.korol.ticket_booking.dto.TripCreateDTO;
import dev.korol.ticket_booking.dto.TripDTO;
import dev.korol.ticket_booking.entity.Trip;
import dev.korol.ticket_booking.exception.NotFoundException;
import dev.korol.ticket_booking.mapper.TripMapper;
import dev.korol.ticket_booking.repository.TripRepository;
import dev.korol.ticket_booking.service.TripService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;
    private final TripMapper tripMapper = Mappers.getMapper(TripMapper.class);

    @Override
    public TripDTO createTrip(TripCreateDTO tripCreateDTO) {
        Trip trip = tripMapper.toTrip(tripCreateDTO);
        Trip saved = tripRepository.save(trip);

        return tripMapper.toTripDTO(saved);
    }

    @Override
    public TripDTO getTripById(Long tripId) {
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new NotFoundException("Trip with ID: " + tripId +  " not found"));

        return tripMapper.toTripDTO(trip);
    }

    @Override
    public TripDTO updateTrip(Long tripId, TripCreateDTO tripCreateDTO) {
        Trip existing = tripRepository.findById(tripId)
                .orElseThrow(() -> new NotFoundException("Trip with ID: " + tripId +  " not found"));

        existing.setDepartureTime(tripCreateDTO.getDepartureTime());
        existing.setArrivalTime(tripCreateDTO.getArrivalTime());
        existing.setOrigin(tripCreateDTO.getOrigin());
        existing.setDestination(tripCreateDTO.getDestination());

        Trip saved = tripRepository.save(existing);

        return tripMapper.toTripDTO(saved);

    }

    @Override
    public List<TripDTO> getAllTrips() {
        return tripRepository.findAll()
                .stream().map(tripMapper::toTripDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTrip(Long tripId) {
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new NotFoundException("Trip with ID: " + tripId +  " not found"));

        tripRepository.delete(trip);

    }
}
