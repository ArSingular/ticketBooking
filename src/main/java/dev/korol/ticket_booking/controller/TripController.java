package dev.korol.ticket_booking.controller;

import dev.korol.ticket_booking.dto.TripCreateDTO;
import dev.korol.ticket_booking.dto.TripDTO;
import dev.korol.ticket_booking.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
@RequiredArgsConstructor
public class TripController {

    private final TripService tripService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TripDTO> createTrip(@RequestBody TripCreateDTO tripCreateDTO) {
        TripDTO tripDTO = tripService.createTrip(tripCreateDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(tripDTO);
    }

    @GetMapping("/{tripId}")
    public ResponseEntity<TripDTO> getTrip(@PathVariable Long tripId){
        return ResponseEntity.ok(tripService.getTripById(tripId));
    }

    @GetMapping
    public ResponseEntity<List<TripDTO>> getAllTrips(){
        return ResponseEntity.ok(tripService.getAllTrips());
    }

    @DeleteMapping("/{tripId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteTrip(@PathVariable Long tripId){
        tripService.deleteTrip(tripId);
        return ResponseEntity.noContent().build();
    }


}
