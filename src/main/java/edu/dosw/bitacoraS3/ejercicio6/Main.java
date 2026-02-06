package edu.dosw.bitacoraS3.ejercicio6;

public class Main {

    public static void main(String[] args) {

        Producto p1 = new Producto("Teclado", 120);
        Producto p2 = new Producto("Mouse", 80);
        Producto p3 = new Producto("Monitor", 900);

        Caja cajaPequena = new Caja();
        cajaPequena.agregar(p1);
        cajaPequena.agregar(p2);

        Caja cajaGrande = new Caja();
        cajaGrande.agregar(cajaPequena);
        cajaGrande.agregar(p3);

        System.out.println("Precio total caja pequeña: " + cajaPequena.getPrecio());
        System.out.println("Precio total caja grande: " + cajaGrande.getPrecio());
    }
}
