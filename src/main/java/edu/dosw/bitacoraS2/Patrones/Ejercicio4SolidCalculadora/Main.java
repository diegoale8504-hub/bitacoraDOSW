package edu.dosw.bitacoraS2.Patrones.Ejercicio4SolidCalculadora;

public class Main {
    public static void main(String[] args){
        Cal calculator = new Cal();

        System.out.println("Suma: " +
                calculator.calculate(50, 100, new Sum()));

        System.out.println("Resta: " +
                calculator.calculate(7.2, 4.5, new Sum()));

        System.out.println("Multiplicación: " +
                calculator.calculate(8, 4, new Sum()));

        System.out.println("División: " +
                calculator.calculate(50, 2, new Sum()));
    }
}
