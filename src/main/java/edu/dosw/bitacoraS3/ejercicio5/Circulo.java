package edu.dosw.bitacoraS3.ejercicio5;

public class Circulo extends Forma {

    public Circulo(Color color) {
        super(color);
    }

    @Override
    public void dibujar() {
        System.out.print("Dibujando círculo en ");
        color.aplicarColor();
    }
}
