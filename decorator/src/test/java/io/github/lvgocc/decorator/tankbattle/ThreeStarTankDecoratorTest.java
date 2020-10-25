package io.github.lvgocc.decorator.tankbattle;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * 三星坦克测试
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/25 12:46
 * @since 1.0.0
 */
class ThreeStarTankDecoratorTest {

    static Tank tank;

    @BeforeAll
    static void setTank() {
        tank = new ThreeStarTankDecorator(new PlayerTank());
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
