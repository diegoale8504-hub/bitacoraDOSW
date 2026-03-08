package edu.dosw.corte1.bitacoraS3.ejercicio1;

public class Paypal implements Payment{
    @Override
    public void Pay(double amount) {
        System.out.println("Paypal por el monto de: " + amount);
    }
}
