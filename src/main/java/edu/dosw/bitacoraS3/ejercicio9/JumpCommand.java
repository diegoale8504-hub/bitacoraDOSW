package edu.dosw.bitacoraS3.ejercicio9;

public class JumpCommand implements Command {

    private final GameCharacter character;

    public JumpCommand(GameCharacter character) {
        this.character = character;
    }

    @Override
    public void execute() {
        character.jump();
    }
}