package edu.dosw.bitacoraS3.ejercicio2;

public class GameEngine {
    private Controller Controller;
    private Game game;
    private UI ui;

    public GameEngine(ConsoleFactory factory){
        Controller = factory.createControl();
        game = factory.createGame();
        ui = factory.createUI();
    }



    public void run(){
        Controller.connect();
        game.start();
        ui.render();
    }
}
