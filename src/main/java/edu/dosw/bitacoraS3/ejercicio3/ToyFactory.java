package edu.dosw.bitacoraS3.ejercicio3;

public class ToyFactory {
    private ToyDollBuilder builder;

    public ToyFactory(ToyDollBuilder builder){
        this.builder = builder;
    }
    public void constructToyDoll() {
        builder.buildHead();
        builder.buildBody();
        builder.buildArms();
        builder.buildLegs();
        builder.buildAccessories();
    }

    public ToyDoll getToyDoll() {
        return builder.getToyDoll();
    }
}
