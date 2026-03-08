package edu.dosw.corte1.bitacoraS3.ejercicio3;

public interface ToyDollBuilder {

    void buildHead();
    void buildBody();
    void buildArms();
    void buildLegs();
    void buildAccessories();

    ToyDoll getToyDoll();
}
