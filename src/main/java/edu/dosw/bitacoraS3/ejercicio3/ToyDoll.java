package edu.dosw.bitacoraS3.ejercicio3;

public class ToyDoll {

    private String head;
    private String body;
    private String arms;
    private String legs;
    private String accessories;

    public void setHead(String head) {
        this.head = head;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setArms(String arms) {
        this.arms = arms;
    }

    public void setLegs(String legs) {
        this.legs = legs;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }

    public void showToy() {
        System.out.println("ToyDoll created:");
        System.out.println("Head: " + head);
        System.out.println("Body: " + body);
        System.out.println("Arms: " + arms);
        System.out.println("Legs: " + legs);
        System.out.println("Accessories: " + accessories);
        System.out.println("--------------------");
    }
}
