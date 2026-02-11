package edu.dosw.bitacoraS2.Patrones.Ejercicio1CreacionalFactoryMethod;

public class PushNotification implements Notification{
    @Override
    public void send(String message){
        System.out.println("Se va a enviar la notificacion en forma push " + message);

    }
}
