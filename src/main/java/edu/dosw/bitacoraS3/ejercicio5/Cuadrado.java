package edu.dosw.bitacoraS3.ejercicio5;

public class Cuadrado extends Forma {

    public Cuadrado(Color color) {
        super(color);
    }

    @Override
    public void dibujar() {
        System.out.print("Dibujando cuadrado en ");
        color.aplicarColor();
    }
}
