package edu.dosw.corte2.semana2.parte2;

public class FraudValidation extends PaymentValidation {

    public boolean validate(double amount){

        System.out.println("Validando fraude...");

        if(next != null){
            return next.validate(amount);
        }

        return true;
    }
}