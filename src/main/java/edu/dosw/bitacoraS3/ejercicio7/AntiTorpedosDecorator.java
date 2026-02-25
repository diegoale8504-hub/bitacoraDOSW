package edu.dosw.bitacoraS3.ejercicio7;

public class AntiTorpedosDecorator extends BarcoBaseDecorator{
    public AntiTorpedosDecorator(Barco barco) {
        super(barco);
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Sistema antitorpedos";
    }

    @Override
    public int poderAtaque() {
        return super.poderAtaque() + 20;
    }
}
