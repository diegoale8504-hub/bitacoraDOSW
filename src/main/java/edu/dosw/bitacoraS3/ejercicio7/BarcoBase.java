package edu.dosw.bitacoraS3.ejercicio7;

public class BarcoBase implements Barco {

    @Override
    public String getDescripcion() {
        return "Barco base";
    }

    @Override
    public int poderAtaque() {
        return 0;
    }

    @Override
    public int defensa() {
        return 0;
    }
}