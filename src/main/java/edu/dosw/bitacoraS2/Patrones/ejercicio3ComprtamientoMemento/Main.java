package edu.dosw.bitacoraS2.Patrones.ejercicio3ComprtamientoMemento;

public class Main {
    public static void main(String[] args) {

        TextEditor editor = new TextEditor();
        History history = new History();

        editor.setContent("Hola");
        history.add(editor.save());

        editor.setContent("Hola Mundo");
        history.add(editor.save());

        editor.setContent("Hola Mundo con Memento");

        System.out.println("Texto actual: " + editor.getContent());

        editor.restore(history.get(0));
        System.out.println("Texto restaurado: " + editor.getContent());
    }
}
