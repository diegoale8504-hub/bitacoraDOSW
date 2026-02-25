package edu.dosw.bitacoraS3.ejercicio9;

public class ComandoCaminar implements Command {
    private final GameCharacter character;

    public ComandoCaminar(GameCharacter character) {
        this.character = character;
    }

    @Override
    public void execute() {
        character.walk();
    }

}
