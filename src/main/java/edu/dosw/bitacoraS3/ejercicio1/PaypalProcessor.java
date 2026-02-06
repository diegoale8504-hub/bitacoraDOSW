package edu.dosw.bitacoraS3.ejercicio1;

public class PaypalProcessor extends PaymentProcessor{
    @Override
    protected Payment createPayment() {
        return new Paypal();
    }
}
