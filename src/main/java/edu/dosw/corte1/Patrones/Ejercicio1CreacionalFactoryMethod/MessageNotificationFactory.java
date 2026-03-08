package edu.dosw.corte1.Patrones.Ejercicio1CreacionalFactoryMethod;

public class MessageNotificationFactory extends NotificationFactory{
    @Override
    public Notification createNotification() {
        return new MessageNotification();
    }
}
