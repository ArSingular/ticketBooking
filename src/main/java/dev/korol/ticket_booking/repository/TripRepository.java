package dev.korol.ticket_booking.repository;

import dev.korol.ticket_booking.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findByOriginAndDestination(String origin, String destination);

}
