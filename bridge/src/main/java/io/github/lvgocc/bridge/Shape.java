package io.github.lvgocc.bridge;

/**
 * 图形
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @date 2020/10/26 18:08
 */
public abstract class Shape {

    protected Color color;

    void setColor(Color color) {
        this.color = color;
    }

    abstract void create();
}
