package dev.korol.ticket_booking.dto;

import dev.korol.ticket_booking.entity.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDTO {

    private String firstName;

    private String lastName;

    @Email(message = "Incorrect email address")
    private String email;

    @Size(min = 6, message = "Password must contain at least 6 characters ")
    private String password;

    private Role role;

}
