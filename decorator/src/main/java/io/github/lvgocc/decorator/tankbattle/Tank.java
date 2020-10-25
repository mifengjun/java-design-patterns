package io.github.lvgocc.decorator.tankbattle;

/**
 * 抽象坦克类
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @date 2020/10/23 17:29
 */
public abstract class Tank {

    /**
     * 移动速度
     */
    protected int moveSpeed;
    /**
     * 射击速度
     */
    protected int shootSpeed;

    public Tank() {
    }

    public Tank(int moveSpeed, int shootSpeed) {
        this.moveSpeed = moveSpeed;
        this.shootSpeed = shootSpeed;
    }

    protected void move() {
        System.out.println("它移动了，当前移动速度：" + moveSpeed);
    }

    protected void fire() {
        System.out.println("它开火了，当前射击速度：" + shootSpeed);
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public int getShootSpeed() {
        return shootSpeed;
    }

    public void setShootSpeed(int shootSpeed) {
        this.shootSpeed = shootSpeed;
    }
}
