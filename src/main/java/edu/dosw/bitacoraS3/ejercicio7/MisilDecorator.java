package edu.dosw.bitacoraS3.ejercicio7;

public class MisilDecorator extends BarcoBaseDecorator{
    public MisilDecorator(Barco barco) {
        super(barco);
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Misiles";
    }

    @Override
    public int poderAtaque() {
        return super.poderAtaque() + 40;
    }
}
