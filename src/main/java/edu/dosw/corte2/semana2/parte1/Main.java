package edu.dosw.corte2.semana2.parte1;

public class Main {

    public static void main(String[] args) {

        NotificationService service = NotificationService.getInstance();

        service.setStrategy(new EmailNotification());
        service.send("Hola por email");

        service.setStrategy(new SMSNotification());
        service.send("Hola por SMS");

        service.setStrategy(new PushNotification());
        service.send("Hola por Push");
    }
}