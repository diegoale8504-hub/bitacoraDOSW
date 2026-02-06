package edu.dosw.bitacoraS3.ejercicio3;

public interface ToyDollBuilder {

    void buildHead();
    void buildBody();
    void buildArms();
    void buildLegs();
    void buildAccessories();

    ToyDoll getToyDoll();
}
