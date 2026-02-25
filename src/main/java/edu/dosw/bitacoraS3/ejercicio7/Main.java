package edu.dosw.bitacoraS3.ejercicio7;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Barco barco = new BarcoBase();

        Map<String, Function<Barco, Barco>> mejoras = Map.of(
                "BLINDAJE", BlindajeDecorator::new,
                "RADAR", RadarDecorator::new,
                "MISILES", MisilDecorator::new,
                "ANTITORPEDOS", AntiTorpedosDecorator::new
        );

        List<String> configuracion = List.of("BLINDAJE", "RADAR", "MISILES");

        for (String key : configuracion) {
            Function<Barco, Barco> decorator = mejoras.get(key);
            if (decorator == null) throw new IllegalArgumentException("Mejora no reconocida: " + key);
            barco = decorator.apply(barco);
        }

        System.out.println(barco.getDescripcion());
        System.out.println("Ataque: " + barco.poderAtaque());
        System.out.println("Defensa: " + barco.defensa());
    }
}