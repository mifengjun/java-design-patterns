package io.github.lvgocc.decorator.tankbattle;

import org.junit.jupiter.api.*;

/**
 * tank 装饰着测试
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/25 12:45
 * @since 1.0.0
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TankDecoratorTest {

    static Tank tank;
    static Tank oneStarTank;
    static Tank twoStarTank;
    static Tank threeStarTank;

    @BeforeAll
    static void setTank() {
        tank = new PlayerTank();
        oneStarTank = new OneStarTankDecorator(tank);
        twoStarTank = new TwoStarTankDecorator(oneStarTank);
        threeStarTank = new ThreeStarTankDecorator(twoStarTank);

    }

    @Test
    @Order(1)
    void tank() {
        System.out.println("玩家坦克");
        tank.move();
        tank.fire();
    }


    @Test
    @Order(3)
    void oneStarTank() {
        System.out.println("吃到一颗星后");
        oneStarTank.move();
        oneStarTank.fire();
    }


    @Test
    @Order(5)
    void twoStarTank() {
        System.out.println("吃到两颗星后");
        twoStarTank.move();
        twoStarTank.fire();
    }

    @Test
    @Order(7)
    void threeStarTank() {
        System.out.println("吃到三颗星后");
        threeStarTank.move();
        threeStarTank.fire();
    }
}
