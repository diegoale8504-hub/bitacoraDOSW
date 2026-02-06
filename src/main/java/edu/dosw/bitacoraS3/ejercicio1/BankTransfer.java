package edu.dosw.bitacoraS3.ejercicio1;

public class BankTransfer implements Payment{
    public void Pay(double amount){
        System.out.println("Transferencia por el monto de: " + amount);
    }
}
