package edu.dosw.bitacoraS2.Patrones.Ejercicio1CreacionalFactoryMethod;

public class EmailNotificationFactory extends NotificationFactory{
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
