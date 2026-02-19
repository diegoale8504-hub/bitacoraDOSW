package edu.dosw.bitacoraS2.Patrones.ejercicio3ComprtamientoMemento;

public class MementoText {
    private final String content;

    MementoText(String content) {
        this.content = content;
    }

    String getSavedContent() {
        return content;
    }
}
