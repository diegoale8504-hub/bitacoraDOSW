package edu.dosw.bitacoraS3.ejercicio7;

public class BlindajeDecorator extends BarcoBaseDecorator{
    public BlindajeDecorator(Barco barco) {
        super(barco);
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Blindaje reforzado";
    }

    @Override
    public int defensa() {
        return super.defensa() + 30;
    }
}
