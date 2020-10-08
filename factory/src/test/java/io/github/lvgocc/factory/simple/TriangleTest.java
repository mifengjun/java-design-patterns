package io.github.lvgocc.factory.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 三角形测试类
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/8 22:16
 * @since 1.0.0
 */
class TriangleTest {

    @Test
    void testToString() {
        final Triangle triangle = new Triangle();
        Assertions.assertEquals(triangle.toString(), "Triangle");
    }
}
