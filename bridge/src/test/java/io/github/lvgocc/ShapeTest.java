package io.github.lvgocc;

import org.junit.jupiter.api.Test;

class ShapeTest {

    @Test
    void shape() {
        Shape blueCircle = new BlueCircle();
        Shape blueRectangle = new BlueRectangle();
        Shape redCircle = new RedCircle();
        Shape redRectangle = new RedRectangle();

        blueCircle.create();
        blueRectangle.create();
        redCircle.create();
        redRectangle.create();
    }
}