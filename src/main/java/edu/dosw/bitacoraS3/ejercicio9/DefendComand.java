package edu.dosw.bitacoraS3.ejercicio9;

public class DefendComand implements Command{
    private final GameCharacter character;
    public DefendComand(GameCharacter character) {
        this.character = character;
    }

    @Override
    public void execute() {
        character.defend();
    }
}
