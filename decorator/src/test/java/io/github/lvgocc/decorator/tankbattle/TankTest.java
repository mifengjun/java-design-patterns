package io.github.lvgocc.decorator.tankbattle;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * tank test
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/25 12:40
 * @since 1.0.0
 */
class TankTest {

    static Tank tank;

    @BeforeAll
    static void before() {
        tank = new Tank() {
        };
    }

    @Test
    void move() {
        tank.move();
    }

    @Test
    void fire() {
        tank.fire();
    }
}
