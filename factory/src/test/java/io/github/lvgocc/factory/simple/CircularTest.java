package io.github.lvgocc.factory.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 圆形测试类
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/8 22:14
 * @since 1.0.0
 */
class CircularTest {

    @Test
    void testToString() {
        Circular circular = new Circular();
        Assertions.assertEquals(circular.toString(), "Circular");
    }
}
