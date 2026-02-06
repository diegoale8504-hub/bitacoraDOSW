package edu.dosw.bitacoraS3.ejercicio4;

public class FastChargerAdapter implements FuelService{
    private FastElectricCharger charger;

    public FastChargerAdapter(FastElectricCharger charger) {
        this.charger = charger;
    }

    @Override
    public void supply(int liters) {
        double kWh = convertLitersToKWh(liters);
        charger.fastCharge(kWh);
    }

    private double convertLitersToKWh(int liters) {
        return liters * 8.0;
    }
}
