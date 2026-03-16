package edu.dosw.corte2.semana2;



import edu.dosw.corte2.semana2.parte2.*;
import org.junit.jupiter.api.Test;

public class TestPaymentProcess {

    @Test
    void testPaymentProcess() {

        PaymentValidation balance = new BalanceValidation();
        PaymentValidation fraud = new FraudValidation();
        PaymentValidation limit = new LimitValidation();

        balance.setNext(fraud);
        fraud.setNext(limit);

        PaymentProvider provider = new PayPalAdapter();

        PaymentService service = new PaymentService(provider, balance);

        service.process(200);

    }

}