package edu.dosw.corte2.semana2.parte2;

public class PaymentService {

    private PaymentProvider provider;
    private PaymentValidation validationChain;

    public PaymentService(PaymentProvider provider, PaymentValidation validationChain){
        this.provider = provider;
        this.validationChain = validationChain;
    }

    public void process(double amount){

        if(validationChain.validate(amount)){
            provider.processPayment(amount);
        } else {
            System.out.println("Pago rechazado");
        }

    }
}