package edu.dosw.corte1.Patrones.Ejercicio4SolidCalculadora;

public class Cal {
    public double calculate(double a, double b, Operacion operacion) {
        return operacion.execute(a, b);
    }
}
