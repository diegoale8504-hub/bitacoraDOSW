package edu.dosw.bitacoraS3.ejercicio2;

public class Main {
    public static void main(String[] args){
        ConsoleFactory factory;

        factory = new PlayStationFactory();
        GameEngine psEngine = new GameEngine(factory);
        psEngine.run();

        System.out.println("Play station funcionando");

        factory = new XboxFactory();
        GameEngine xboxEngine = new GameEngine(factory);
        xboxEngine.run();
    }
}
