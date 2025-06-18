package dev.korol.ticket_booking.controller;

import dev.korol.ticket_booking.dto.UserCreateDTO;
import dev.korol.ticket_booking.dto.UserDTO;
import dev.korol.ticket_booking.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserCreateDTO userCreateDTO) {

        UserDTO userDTO = userService.createUser(userCreateDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }



    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }


}
