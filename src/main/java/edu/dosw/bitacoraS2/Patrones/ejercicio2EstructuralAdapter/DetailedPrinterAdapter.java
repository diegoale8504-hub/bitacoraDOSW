package edu.dosw.bitacoraS2.Patrones.ejercicio2EstructuralAdapter;
import java.time.LocalDate;

public class DetailedPrinterAdapter implements MessagePrinter {
    private final DetailedPrinter detailedPrinter;
    private final String author;
    private final LocalDate date;

    public DetailedPrinterAdapter(DetailedPrinter detailedPrinter,
                                  String author,
                                  LocalDate date) {
        this.detailedPrinter = detailedPrinter;
        this.author = author;
        this.date = date;
    }

    @Override
    public void print(String message) {
        detailedPrinter.printDetailed(message, author, date);
    }
}
