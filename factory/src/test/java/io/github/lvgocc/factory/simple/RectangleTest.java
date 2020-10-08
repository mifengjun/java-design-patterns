package io.github.lvgocc.factory.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 矩形测试
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/8 22:15
 * @since 1.0.0
 */
class RectangleTest {

    @Test
    void testToString() {
        Rectangle rectangle = new Rectangle();
        Assertions.assertEquals(rectangle.toString(), "Rectangle");
    }
}
