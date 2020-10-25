package io.github.lvgocc.decorator.tankbattle;

/**
 * 三星坦克装饰者
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/25 11:41
 * @since 1.0.0
 */
public class ThreeStarTankDecorator extends TankDecorator {
    public ThreeStarTankDecorator(Tank tank) {
        super(tank);
    }


    @Override
    protected void fire() {
        super.fire();
        System.out.println("白色砖头击碎");
    }
}
