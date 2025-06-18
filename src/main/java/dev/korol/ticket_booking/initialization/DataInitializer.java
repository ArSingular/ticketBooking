package dev.korol.ticket_booking.initialization;

import dev.korol.ticket_booking.entity.*;
import dev.korol.ticket_booking.entity.enums.Role;
import dev.korol.ticket_booking.entity.enums.SeatType;
import dev.korol.ticket_booking.entity.enums.TicketStatus;
import dev.korol.ticket_booking.entity.enums.TransportType;
import dev.korol.ticket_booking.repository.TicketRepository;
import dev.korol.ticket_booking.repository.TripRepository;
import dev.korol.ticket_booking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final TripRepository tripRepository;
    private final TicketRepository ticketRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Створення користувачів
        String pw = "P@ssword123";

        User user = new User(null,"kucharthur267@gmail.com", passwordEncoder.encode(pw), "Artur" , "Kuch",null, Role.ADMIN);
        userRepository.saveAll(List.of(user));

        // Створення поїздок
        Trip trip1 = new Trip(null, "Kyiv", "Lviv",
                LocalDateTime.of(2025, 6, 1, 8, 0),
                LocalDateTime.of(2025, 6, 1, 12, 0),
                TransportType.BUS, null);
        Trip trip2 = new Trip(null, "Odesa", "Kharkiv",
                LocalDateTime.of(2025, 6, 2, 14, 0),
                LocalDateTime.of(2025, 6, 2, 20, 0),
                TransportType.BUS,null);
        tripRepository.saveAll(List.of(trip1, trip2));

        // Створення квитків
        Ticket ticket1 = new Ticket(null, "A1", TicketStatus.AVAILABLE, new BigDecimal("500.00"), null, SeatType.ECONOMY, trip1, null);
        Ticket ticket2 = new Ticket(null, "B2", TicketStatus.BOOKED, new BigDecimal("650.00"), LocalDateTime.now(), SeatType.BUSINESS, trip2, user);
        ticketRepository.saveAll(List.of(ticket1, ticket2));

        System.out.println("✅ Initial test data loaded");
    }
}
