package dev.korol.ticket_booking.service;

import dev.korol.ticket_booking.mapper.UserMapper;
import dev.korol.ticket_booking.repository.UserRepository;
import dev.korol.ticket_booking.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;


@ExtendWith(MockitoExtension.class)
class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    private UserServiceImpl userService;
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {

        userService = new UserServiceImpl(userRepository, passwordEncoder);
    }

    @Test
    void createUser_ShouldReturnUserDTO() {
//        UserCreateDTO dto = new UserCreateDTO("test", "test@gmail.com", "1234", Role.USER);
//        User user = userMapper.toUser(dto);
//        user.setId(1L);
//
//        when(userRepository.save(any(User.class))).thenReturn(user);
//
//        UserDTO result = userService.createUser(dto);
//
//        assertEquals("test", result.getUsername());
    }
}
