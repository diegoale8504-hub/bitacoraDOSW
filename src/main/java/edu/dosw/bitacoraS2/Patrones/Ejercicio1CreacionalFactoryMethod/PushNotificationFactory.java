package edu.dosw.bitacoraS2.Patrones.Ejercicio1CreacionalFactoryMethod;

public class PushNotificationFactory extends NotificationFactory{
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}
