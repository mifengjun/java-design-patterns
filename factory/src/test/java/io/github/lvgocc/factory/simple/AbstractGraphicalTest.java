package io.github.lvgocc.factory.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 抽象图形类
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/8 22:11
 * @since 1.0.0
 */
class AbstractGraphicalTest {

    @Test
    void testToString() {
        final Graphical abstractGraphical = new Graphical() {
        };
        Assertions.assertEquals(abstractGraphical.toString(), "");
    }
}
