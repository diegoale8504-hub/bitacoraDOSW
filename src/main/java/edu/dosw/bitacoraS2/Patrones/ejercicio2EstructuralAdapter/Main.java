package edu.dosw.bitacoraS2.Patrones.ejercicio2EstructuralAdapter;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        MessagePrinter simplePrinter = new SimplePrinter();
        simplePrinter.print("Hola desde impresora simple");

        MessagePrinter adaptedPrinter = new DetailedPrinterAdapter(
                new DetailedPrinter(),
                "Diego Rozo",
                LocalDate.now()
        );

        adaptedPrinter.print("Hola desde impresora detallada adaptada");

    }
}
