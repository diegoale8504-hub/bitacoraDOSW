package edu.dosw.bitacoraS1.ejercicio3;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<User> usuarios = Arrays.asList(
                new User(1, "Josefa", 22, true),
                new User(2, "Maria", 19, false),
                new User(3, "Luisa", 30, true),
                new User(4, "Marta", 25, true),
                new User(5, "Juan", 28, false)
        );


        List<String> nombresActivos = usuarios.stream()
                .filter(User::isActive)
                .map(User::getName)
                .map(String::toUpperCase)
                .sorted()
                .toList();

        System.out.println("Usuarios activos (ordenados y en mayúscula):");
        System.out.println(nombresActivos);
    }
}
