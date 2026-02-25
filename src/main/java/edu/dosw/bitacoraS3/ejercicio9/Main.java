package edu.dosw.bitacoraS3.ejercicio9;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        GameCharacter character = new GameCharacter();
        GameController controller = new GameController();

        List<Command> actions = List.of(
                new ComandoCaminar(character),
                new JumpCommand(character),
                new AttackCommand(character),
                new DefendComand(character)
        );

        actions.forEach(controller::pressButton);
    }
}