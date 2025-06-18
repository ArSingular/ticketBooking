package dev.korol.ticket_booking.service.impl;

import dev.korol.ticket_booking.dto.UserCreateDTO;
import dev.korol.ticket_booking.dto.UserDTO;
import dev.korol.ticket_booking.entity.User;
import dev.korol.ticket_booking.entity.enums.Role;
import dev.korol.ticket_booking.exception.NotFoundException;
import dev.korol.ticket_booking.mapper.UserMapper;
import dev.korol.ticket_booking.repository.UserRepository;
import dev.korol.ticket_booking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDTO createUser(UserCreateDTO userCreateDTO) {
        User user = userMapper.toUser(userCreateDTO);
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User saved = userRepository.save(user);
        return userMapper.toUserDTO(saved);
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User with ID: " + userId +  " not found"));
        return userMapper.toUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User with ID: " + userId +  " not found"));
        userRepository.delete(user);
    }
}
