package edu.dosw.bitacoraS3.ejercicio11;

public class NavigationApp {

    private RouteStrategy routeStrategy;

    public NavigationApp(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void setRouteStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void startNavigation() {
        if (routeStrategy == null) {
            throw new IllegalStateException("No hay estrategia de ruta configurada.");
        }
        routeStrategy.calculateRoute();
        System.out.println("Navegación iniciada.\n");
    }
}