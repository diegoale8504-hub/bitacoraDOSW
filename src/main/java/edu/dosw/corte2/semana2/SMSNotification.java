package edu.dosw.corte2.semana2;

import javax.management.Notification;
import javax.management.NotificationFilter;
import java.awt.*;

public class SMSNotification implements NotificationStrategy {

    @Override
    public void sendNotification(String message) {
        System.out.println("Enviando SMS: " + message);
    }
}

