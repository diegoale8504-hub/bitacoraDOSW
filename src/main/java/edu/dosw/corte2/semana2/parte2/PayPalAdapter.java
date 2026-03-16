package edu.dosw.corte2.semana2.parte2;

public class PayPalAdapter implements PaymentProvider {

    private PayPalAPI paypal = new PayPalAPI();

    @Override
    public void processPayment(double amount) {
        paypal.makePayment(amount);
    }
}
