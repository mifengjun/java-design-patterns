package io.github.lvgocc.decorator.tankbattle;

/**
 * 两星坦克装饰者
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/25 11:40
 * @since 1.0.0
 */
public class TwoStarTankDecorator extends TankDecorator {
    public TwoStarTankDecorator(Tank tank) {
        super(tank);
    }


    @Override
    protected void fire() {
        super.fire();
        super.fire();
    }
}
