package io.github.lvgocc.decorator.tankbattle;

/**
 * 玩家坦克
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/25 11:40
 * @since 1.0.0
 */
public class PlayerTank extends Tank {

    /**
     * 玩家默认坦克数据，移动，设计速度 1
     */
    public PlayerTank() {
        super(1, 1);
    }
}
