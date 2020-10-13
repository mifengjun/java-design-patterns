package io.github.lvgocc.factory.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 图形工厂测试类
 *
 * client
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/8 22:17
 * @since 1.0.0
 */
class GraphicalFactoryTest {

    @Test
    void create() {
        final Graphical circular = GraphicalFactory.create(0);
        Assertions.assertEquals(circular.toString(), "Circular");

        final Graphical rectangle = GraphicalFactory.create(1);
        Assertions.assertEquals(rectangle.toString(), "Rectangle");

        final Graphical triangle = GraphicalFactory.create(2);
        Assertions.assertEquals(triangle.toString(), "Triangle");
    }
}
