package edu.dosw.bitacoraS3.ejercicio11;

public class Main {

    public static void main(String[] args) {
        // Client
        NavigationApp app = new NavigationApp(new FastestRoute());
        app.startNavigation();

        app.setRouteStrategy(new ScenicRoute());
        app.startNavigation();

        app.setRouteStrategy(new CheapestRoute());
        app.startNavigation();
    }
}