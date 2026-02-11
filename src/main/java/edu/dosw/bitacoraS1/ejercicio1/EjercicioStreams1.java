package edu.dosw.bitacoraS1.ejercicio1;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



public class EjercicioStreams1 {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(3, 8, 10, 12, 15, 18, 7, 22, 9);

        List<Integer> paresMayoresADiez = numeros.stream()
                .filter(n -> n % 2 == 0)
                .filter(n -> n > 10)
                .collect(Collectors.toList());

        System.out.println(paresMayoresADiez);
    }
}