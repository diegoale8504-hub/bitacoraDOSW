package edu.dosw.bitacoraS3.ejercicio3;

public class ClassicToyDollBuilder implements ToyDollBuilder {

    private ToyDoll toyDoll = new ToyDoll();

    public void buildHead() {
        toyDoll.setHead("Delicate head");
    }

    public void buildBody() {
        toyDoll.setBody("Classic body");
    }

    public void buildArms() {
        toyDoll.setArms("Simple arms");
    }

    public void buildLegs() {
        toyDoll.setLegs("Simple legs");
    }



    public void buildAccessories() {
        toyDoll.setAccessories("Dress");
    }

    public ToyDoll getToyDoll() {
        return toyDoll;
    }
}
