package edu.dosw.bitacoraS3.ejercicio7;

public abstract class BarcoBaseDecorator implements Barco {
    protected final Barco barco;

    protected BarcoBaseDecorator(Barco barco) {
        this.barco = barco;
    }

    @Override
    public String getDescripcion() {
        return barco.getDescripcion();
    }

    @Override
    public int poderAtaque() {
        return barco.poderAtaque();
    }

    @Override
    public int defensa() {
        return barco.defensa();
    }
}
