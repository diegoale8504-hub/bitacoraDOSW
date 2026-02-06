package edu.dosw.bitacoraS3.ejercicio2;

public class PlayStationFactory implements ConsoleFactory {

    public Controller createControl(){
        return new PlayStationController();
    }

    public Game createGame(){
        return new PlayStationGame();
    }

    public UI createUI(){
        return new PlayStationUI();
    }

}
