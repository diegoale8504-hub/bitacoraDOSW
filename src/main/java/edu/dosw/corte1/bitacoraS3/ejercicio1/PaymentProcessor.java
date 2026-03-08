package edu.dosw.corte1.bitacoraS3.ejercicio1;

public abstract class PaymentProcessor {

    public void processPayment(double amount){
        Payment payment = createPayment();
        payment.Pay(amount);
    }

    protected abstract Payment createPayment();

}
