package edu.dosw.corte2.semana2.parte2;

public abstract class PaymentValidation {

    protected PaymentValidation next;

    public void setNext(PaymentValidation next){
        this.next = next;
    }

    public abstract boolean validate(double amount);
}