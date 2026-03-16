package edu.dosw.corte2.semana2.parte1;

public class PushNotification implements NotificationStrategy {

    @Override
    public void sendNotification(String message) {
        System.out.println("Enviando PUSH: " + message);
    }
}
