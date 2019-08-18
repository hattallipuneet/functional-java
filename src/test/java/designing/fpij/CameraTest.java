package designing.fpij;

import org.junit.Test;

import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class CameraTest {

    @Test
    public void testCamera() {
        final Camera camera = new Camera();
        final Consumer<String> printCaptured =
                (filterInfo) -> System.out.println(String.format("with %s : %s",
                        filterInfo, camera.capture(new Color(200, 100, 200))));
        printCaptured.accept("no filter");

        camera.setFilters(Color::brighter);
        printCaptured.accept("brighter filter");

        camera.setFilters(Color::darker);
        printCaptured.accept("darker filter");

        camera.setFilters(Color::brighter, Color::darker);
        printCaptured.accept("brighter darker filter");
    }
}
