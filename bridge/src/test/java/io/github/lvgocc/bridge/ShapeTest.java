package io.github.lvgocc.bridge;

import org.junit.jupiter.api.Test;

class ShapeTest {

    @Test
    void shape() {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        circle.setColor(new Red());
        rectangle.setColor(new Red());

        circle.create();
        rectangle.create();

        circle.setColor(new Blue());
        rectangle.setColor(new Blue());

        circle.create();
        rectangle.create();

    }
}