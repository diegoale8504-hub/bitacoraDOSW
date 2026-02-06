package edu.dosw.bitacoraS3.ejercicio4;

public class Main {

    public static void main(String[] args) {
        FuelService gaslinePump = new FuelService() {
            @Override
            public void supply(int ammount) {

            }
        };
        FuelService fastElectricPump =
                new FastChargerAdapter(new FastElectricCharger());
        FuelService slowElectricPump =
                new SlowChargerAdapter(new SlowElectricCharger());

        gaslinePump.supply(30);
        fastElectricPump.supply(30);
        slowElectricPump.supply(30);
    }
}
