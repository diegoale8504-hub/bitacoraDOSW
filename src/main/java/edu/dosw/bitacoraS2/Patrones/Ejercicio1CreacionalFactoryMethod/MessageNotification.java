package edu.dosw.bitacoraS2.Patrones.Ejercicio1CreacionalFactoryMethod;

public class MessageNotification implements Notification{
    @Override
    public void send(String message) {
        System.out.println("Sending message: " + message);

    }
}
