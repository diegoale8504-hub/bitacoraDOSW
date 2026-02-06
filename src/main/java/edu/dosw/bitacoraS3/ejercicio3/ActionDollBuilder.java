package edu.dosw.bitacoraS3.ejercicio3;

public class ActionDollBuilder implements ToyDollBuilder {
    private ToyDoll toyDoll = new ToyDoll();

    @Override
    public void buildHead() {
        toyDoll.setHead("Strong head");

    }

    @Override
    public void buildBody() {
        toyDoll.setBody("Muscular body");

    }

    @Override
    public void buildArms() {
        toyDoll.setArms("Arms");
    }

    @Override
    public void buildLegs() {
        toyDoll.setLegs("legs");
    }

    @Override
    public void buildAccessories() {
        toyDoll.setAccessories("Big monky on shoulder");
    }



    public ToyDoll getToyDoll() {
        return toyDoll;
    }
}
