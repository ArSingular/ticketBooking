package dev.korol.ticket_booking.entity.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    USER,
    ADMIN;


    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }
}
