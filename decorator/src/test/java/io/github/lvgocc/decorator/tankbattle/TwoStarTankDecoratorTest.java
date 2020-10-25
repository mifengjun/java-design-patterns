package io.github.lvgocc.decorator.tankbattle;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * 两星坦克测试
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/25 12:48
 * @since 1.0.0
 */
class TwoStarTankDecoratorTest {

    static Tank tank;

    @BeforeAll
    static void setTank() {
        tank = new TwoStarTankDecorator(new PlayerTank());
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
