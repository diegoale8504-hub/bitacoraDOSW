package edu.dosw.bitacoraS2.Patrones.ejercicio3ComprtamientoMemento;

public class TextEditor {
    private String content;

    public TextEditor() {
        this.content = "";
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    // Guarda el estado actual
    public MementoText save() {
        return new MementoText(content);
    }

    // Restaura un estado anterior
    public void restore(MementoText memento) {
        this.content = memento.getSavedContent();
    }
}
