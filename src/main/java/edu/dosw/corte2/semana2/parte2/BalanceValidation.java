package edu.dosw.corte2.semana2.parte2;

public class BalanceValidation extends PaymentValidation {

    public boolean validate(double amount) {

        System.out.println("Validando saldo...");

        if(amount > 1000){
            System.out.println("Saldo insuficiente");
            return false;
        }

        if(next != null){
            return next.validate(amount);
        }

        return true;
    }
}