package edu.dosw.corte2.semana2.parte2;

public class StripeAdapter implements PaymentProvider {

    private StripeAPI stripe = new StripeAPI();

    @Override
    public void processPayment(double amount) {
        stripe.charge(amount);
    }
}
