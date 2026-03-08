package edu.dosw.corte1.bitacoraS3.ejercicio1;

public class CreditCardProcessor extends PaymentProcessor{
    @Override
    protected Payment createPayment() {
        return new CreditCard();
    }
}
