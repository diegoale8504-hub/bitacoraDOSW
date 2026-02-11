package edu.dosw.bitacoraS2.Patrones.Ejercicio1CreacionalFactoryMethod;

public class MessageNotificationFactory extends NotificationFactory{
    @Override
    public Notification createNotification() {
        return new MessageNotification();
    }
}
