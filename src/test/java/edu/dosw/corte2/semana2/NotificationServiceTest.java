package edu.dosw.corte2.semana2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class NotificationServiceTest {

    @Test
    void testEmailNotification() {

        NotificationService service = NotificationService.getInstance();
        service.setStrategy(new EmailNotification());

        assertDoesNotThrow(() -> service.send("Test email"));
    }

    @Test
    void testSMSNotification() {

        NotificationService service = NotificationService.getInstance();
        service.setStrategy(new SMSNotification());

        assertDoesNotThrow(() -> service.send("Test SMS"));
    }
}