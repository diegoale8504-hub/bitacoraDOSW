package edu.dosw.bitacoraS3.ejercicio7;

public class RadarDecorator extends BarcoBaseDecorator {
    public RadarDecorator(Barco barco) {
        super(barco);
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Radar avanzado";
    }

    @Override
    public int poderAtaque() {
        return super.poderAtaque() + 8;

    }


}