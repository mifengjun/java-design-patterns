package io.github.lvgocc.factory.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 图形工厂测试类
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/8 22:17
 * @since 1.0.0
 */
class GraphicalFactoryTest {

    @Test
    void create() {
        final AbstractGraphical circular = GraphicalFactory.create(0);
        Assertions.assertEquals(circular.toString(), "Circular");

        final AbstractGraphical rectangle = GraphicalFactory.create(1);
        Assertions.assertEquals(rectangle.toString(), "Rectangle");

        final AbstractGraphical triangle = GraphicalFactory.create(2);
        Assertions.assertEquals(triangle.toString(), "Triangle");
    }
}
