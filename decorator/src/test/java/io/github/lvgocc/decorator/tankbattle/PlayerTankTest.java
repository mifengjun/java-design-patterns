package io.github.lvgocc.decorator.tankbattle;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * 玩家 tank 测试
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/25 12:44
 * @since 1.0.0
 */
class PlayerTankTest {

    static Tank tank;

    @BeforeAll
    static void before() {
        tank = new PlayerTank();
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
