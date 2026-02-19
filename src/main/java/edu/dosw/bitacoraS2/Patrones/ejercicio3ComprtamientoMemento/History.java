package edu.dosw.bitacoraS2.Patrones.ejercicio3ComprtamientoMemento;
import java.util.ArrayList;
import java.util.List;

public class History {
    private final List<MementoText> mementos = new ArrayList<>();

    public void add(MementoText memento) {
        mementos.add(memento);
    }

    public MementoText get(int index) {
        return mementos.get(index);
    }
}
