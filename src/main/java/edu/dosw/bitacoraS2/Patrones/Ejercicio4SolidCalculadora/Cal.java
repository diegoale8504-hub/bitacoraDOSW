package edu.dosw.bitacoraS2.Patrones.Ejercicio4SolidCalculadora;

public class Cal {
    public double calculate(double a, double b, Operacion operacion) {
        return operacion.execute(a, b);
    }
}
