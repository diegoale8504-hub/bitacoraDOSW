package edu.dosw.bitacoraS3.ejercicio3;

public class Main {
    public static void main(String[] args) {


        ActionDollBuilder actionBuilder = new ActionDollBuilder();
        ToyFactory actionFactory = new ToyFactory(actionBuilder);
        actionFactory.constructToyDoll();
        ToyDoll actionDoll = actionFactory.getToyDoll();
        actionDoll.showToy();


        ClassicToyDollBuilder classicBuilder = new ClassicToyDollBuilder();
        ToyFactory classicFactory = new ToyFactory(classicBuilder);
        classicFactory.constructToyDoll();
        ToyDoll classicDoll = classicFactory.getToyDoll();
        classicDoll.showToy();
    }
}
