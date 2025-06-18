package dev.korol.ticket_booking.mapper;

import dev.korol.ticket_booking.dto.UserCreateDTO;
import dev.korol.ticket_booking.dto.UserDTO;
import dev.korol.ticket_booking.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    User toUser(UserDTO userDTO);

    @Mapping(source = "role", target = "role")
    User toUser(UserCreateDTO userCreateDTO);

    @Mapping(source = "role", target = "role")
    UserDTO toUserDTO(User user);

}
