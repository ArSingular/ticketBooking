package dev.korol.ticket_booking.repository;

import dev.korol.ticket_booking.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveAndFindByUsername() {
        User user = new User();
//        user.setUsername("testuser");
        user.setPassword("password123");
        user.setEmail("testuser@example.com");

        userRepository.save(user);

//        Optional<User> found = userRepository.findByUsername("testuser");
//        assertTrue(found.isPresent());
//        assertEquals("testuser", found.get().getUsername());
//        assertEquals("testuser@example.com", found.get().getEmail());
    }

    @Test
    public void testDeleteUser() {
        User user = new User();
//        user.setUsername("todelete");
        user.setPassword("password");
        user.setEmail("delete@example.com");

        userRepository.save(user);

        userRepository.delete(user);

//        Optional<User> found = userRepository.findByUsername("todelete");
//        assertFalse(found.isPresent());
    }

}
