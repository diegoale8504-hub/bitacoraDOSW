package edu.dosw.corte2.semana2.parte2;

public class LimitValidation extends PaymentValidation {

    public boolean validate(double amount){

        System.out.println("Validando límite de transacciones...");

        if(next != null){
            return next.validate(amount);
        }

        return true;
    }
}