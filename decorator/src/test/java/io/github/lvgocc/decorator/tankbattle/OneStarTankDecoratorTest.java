package io.github.lvgocc.decorator.tankbattle;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * 一行坦克测试类
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/25 12:42
 * @since 1.0.0
 */
class OneStarTankDecoratorTest {

    private static Tank tank;

    @BeforeAll
    static void before() {
        tank = new OneStarTankDecorator(new PlayerTank());
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
