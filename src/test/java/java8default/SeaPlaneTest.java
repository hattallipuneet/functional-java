package java8default;

import org.junit.Test;

public class SeaPlaneTest {

    @Test
    public void testSeaPlaneTest() {
        SeaPlane seaPlane = new SeaPlane();
        seaPlane.takeOff();
        seaPlane.turn();
        seaPlane.cruise();
        seaPlane.land();
    }
}
