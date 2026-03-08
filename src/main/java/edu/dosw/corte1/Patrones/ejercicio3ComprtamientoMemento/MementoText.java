package edu.dosw.corte1.Patrones.ejercicio3ComprtamientoMemento;

public class MementoText {
    private final String content;

    MementoText(String content) {
        this.content = content;
    }

    String getSavedContent() {
        return content;
    }
}
