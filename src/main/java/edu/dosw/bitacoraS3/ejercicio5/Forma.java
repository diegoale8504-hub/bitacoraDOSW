package edu.dosw.bitacoraS3.ejercicio5;

public abstract class Forma {

    protected Color color;

    public Forma(Color color) {
        this.color = color;
    }

    public abstract void dibujar();
}
