package edu.dosw.corte1.Patrones.Ejercicio1CreacionalFactoryMethod;

public class PushNotificationFactory extends NotificationFactory{
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}
