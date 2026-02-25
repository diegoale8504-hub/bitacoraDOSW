package edu.dosw.bitacoraS3.ejercicio9;

public class AttackCommand implements Command {

    private final GameCharacter character;

    public AttackCommand(GameCharacter character) {
        this.character = character;
    }

    @Override
    public void execute() {
        character.attack();
    }
}