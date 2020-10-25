package io.github.lvgocc.decorator.tankbattle;

/**
 * 一星坦克装饰者
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/25 11:40
 * @since 1.0.0
 */
public class OneStarTankDecorator extends TankDecorator {
    public OneStarTankDecorator(Tank tank) {
        super(tank);
    }

    @Override
    protected void move() {
        tank.setMoveSpeed(2);
        super.move();
    }

    @Override
    protected void fire() {
        tank.setShootSpeed(2);
        super.fire();
    }
}
