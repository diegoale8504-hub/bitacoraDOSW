package edu.dosw.corte1.Patrones.Ejercicio1CreacionalFactoryMethod;

public class EmailNotification implements Notification{
    @Override
    public void send(String message){
        System.out.println("Correo electronico" + message);
    }
}
