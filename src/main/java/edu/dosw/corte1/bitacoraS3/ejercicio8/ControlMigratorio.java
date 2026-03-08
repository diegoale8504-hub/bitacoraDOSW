package edu.dosw.corte1.bitacoraS3.ejercicio8;

public interface ControlMigratorio {
    void setSiguiente(ControlMigratorio siguiente);
    void procesar(IngresoRequest request);
}