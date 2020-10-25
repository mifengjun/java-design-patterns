package io.github.lvgocc.decorator.tankbattle;

/**
 * 定义坦克抽象装饰者
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/25 11:40
 * @since 1.0.0
 */
public abstract class TankDecorator extends Tank {

    protected Tank tank;

    public TankDecorator(Tank tank) {
        this.tank = tank;
    }

    @Override
    protected void move() {
        tank.move();
    }

    @Override
    protected void fire() {
        tank.fire();
    }
}
