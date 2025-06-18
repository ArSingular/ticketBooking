package dev.korol.ticket_booking.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Korol Artur
 * 12.06.2025
 */
@Getter
@RequiredArgsConstructor
public enum EmailMessageType {

    ACTIVATE("activate",
            "Verify your account",
            """
                    Dear, %s! Thank you for creating an account in our service.
                    Please click the link down bellow for verifying account.
                    Link: %s"""),
    RESTORE_PASSWORD("restore/password",
            "Restore password for your account",
            "Dear, %s! For restoring password for your account in our service " +
                    "please click the link down bellow for changing to new password.\n" +
                    "Link: %s");

    private final String emailType;
    private final String subject;
    private final String messageBody;

}
