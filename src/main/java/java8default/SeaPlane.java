package java8default;

public class SeaPlane extends Vehicle implements FastFly, Sail {

    private int altitude;

    @Override
    public void cruise() {
        System.out.println("SeaPlane:: cruise currently cruising like");
        if (altitude> 0) {
            FastFly.super.cruise();
        }else {
            Sail.super.cruise();
        }
    }
}
