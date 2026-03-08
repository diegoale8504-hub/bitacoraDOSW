package edu.dosw.corte1.bitacoraS3.ejercicio1;

public class BankTransferProcessor extends PaymentProcessor {
    @Override
    protected Payment createPayment() {
        return new BankTransfer();
    }
}
