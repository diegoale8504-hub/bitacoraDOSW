package edu.dosw.bitacoraS2.Patrones.ejercicio2EstructuralAdapter;

public class SimplePrinter implements MessagePrinter{
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
