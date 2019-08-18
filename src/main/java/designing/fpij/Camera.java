package designing.fpij;

import java.awt.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class Camera {

    private Function<Color, Color> filter;

    public Camera() {
        setFilters();
    }

    public Color capture(final Color inputColor){
        final Color outputColor = filter.apply(inputColor);
        return outputColor;
    }

    public void setFilters(final Function<Color, Color>... filters) {
        filter = Stream.of(filters)
                        .reduce(Function::compose)
                        .orElseGet(Function::identity);
    }

}
