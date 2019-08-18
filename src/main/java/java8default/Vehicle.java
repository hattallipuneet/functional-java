package java8default;

public class Vehicle implements Fly {

    @Override
    public void turn() {
        System.out.println("Vehicle::turn");
    }
}
