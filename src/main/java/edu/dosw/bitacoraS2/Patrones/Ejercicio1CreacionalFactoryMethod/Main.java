package edu.dosw.bitacoraS2.Patrones.Ejercicio1CreacionalFactoryMethod;

public class Main {
    public static void main(String[] args){
        NotificationFactory factory;

        factory = new EmailNotificationFactory();
        Notification email = factory.createNotification();
        email.send("Hola desde Email");

        factory = new MessageNotificationFactory();
        Notification sms = factory.createNotification();
        sms.send("Hola desde Message");

        factory = new PushNotificationFactory();
        Notification push = factory.createNotification();
        push.send("Hola desde Push");
    }
}
