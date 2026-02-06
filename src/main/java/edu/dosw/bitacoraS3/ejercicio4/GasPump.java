package edu.dosw.bitacoraS3.ejercicio4;

public class GasPump {
    private FuelService fuelService;

    public GasPump(FuelService fuelService){
        this.fuelService = fuelService;
    }

    public void supply(int liters){
        fuelService.supply(liters);
    }

}
