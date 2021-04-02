package chapter4.patterns.decorator;

import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Camera {

    /*Chain delegates to realize decorator pattern*/

    private Function<Color, Color> filter;

    public Color capture(final Color inputColor) {
        final Color processedColor = filter.apply(inputColor);
        return processedColor;
    }

    /*In java 8 interfaces can have methods with implementation, marked as default.
     * these implementations are automatically added to the classes that
     * implement the interfaces.
     * Interfaces can also have static methods.*/

    /*In addition to the apply() abstract method, Function interface has
     * a default method, compose(), to combine or chain multiple Functions.
     * Once we compose them, a call to apply() will will hop through the chained
     * Functions.
     *
     * Example
     * ----------------
     * target.compose(next).apply(input); = evaluates to => next.apply(target.apply(input));
     * */

    public Camera() {
        setFilters();
    }

    public void setFilters(final Function<Color, Color>... filters) {
        filter = Stream.of(filters)
                .reduce((filter, next) -> filter.compose(next))
                //reduce(Function::compose) // automatically routes the variables as target and arg
                .orElseGet(Function::identity); //identity function simply returns the value that is passed to it.
        //.orElse(color -> color);
    }


    public static void main(String[] args) {
        final Camera camera = new Camera();
        final Color inputColor = new Color(200, 100, 200);
        final Consumer<String> printCaptured = (filterInfo) ->
                System.out.printf("with %s: %s",
                        filterInfo, camera.capture(inputColor));

        camera.setFilters(Color::brighter, Color::darker);
        printCaptured.accept("brighter filter");


    }

}
