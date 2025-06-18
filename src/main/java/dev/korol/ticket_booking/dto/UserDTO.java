package dev.korol.ticket_booking.dto;

import dev.korol.ticket_booking.entity.enums.Role;
import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Role role;

}
