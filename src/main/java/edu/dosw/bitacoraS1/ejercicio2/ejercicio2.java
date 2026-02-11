package edu.dosw.bitacoraS1.ejercicio2;
import java.util.Arrays;
import java.util.List;

public class ejercicio2 {
    public static void main(String[] args) {

        List<String> palabras = Arrays.asList(
                "java", "streams", "api", "lambda", "code", "programacion", "git"
        );

        List<String> resultado = palabras.stream()
                .filter(p -> p.length() > 4)
                .map(String::toUpperCase)
                .sorted()
                .toList();

        long cantidad = resultado.size();

        System.out.println("Palabras resultantes: " + resultado);
        System.out.println("Cantidad total: " + cantidad);
    }
}
