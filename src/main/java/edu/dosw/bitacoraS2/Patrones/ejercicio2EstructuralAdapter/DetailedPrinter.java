package edu.dosw.bitacoraS2.Patrones.ejercicio2EstructuralAdapter;
import java.time.LocalDate;
public class DetailedPrinter {
    public void printDetailed(String message, String author, LocalDate date) {
        System.out.println("Mensaje: " + message);
        System.out.println("Autor: " + author);
        System.out.println("Fecha: " + date);
    }
}
