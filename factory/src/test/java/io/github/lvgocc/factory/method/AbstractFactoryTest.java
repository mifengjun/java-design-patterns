package io.github.lvgocc.factory.method;

import org.junit.jupiter.api.Test;

/**
 * 工厂方法测试类
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/8 23:28
 * @since 1.0.0
 */
class AbstractFactoryTest {

    @Test
    void creat() {
        AbstractFactory circularFactory = new CircularFactory();
        Graphical circular = circularFactory.creat();
        circular.description();

        System.out.println();

        AbstractFactory rectangleFactory = new RectangleFactory();
        Graphical rectangle = rectangleFactory.creat();
        rectangle.description();

        System.out.println();

        AbstractFactory triangleFactory = new TriangleFactory();
        Graphical triangle = triangleFactory.creat();
        triangle.description();
    }
}
