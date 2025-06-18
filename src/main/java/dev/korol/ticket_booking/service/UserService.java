package dev.korol.ticket_booking.service;

import dev.korol.ticket_booking.dto.UserCreateDTO;
import dev.korol.ticket_booking.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserCreateDTO userCreateDTO);
    UserDTO getUserById(Long userId);
    List<UserDTO> getAllUsers();
    void deleteUser(Long userId);

}
