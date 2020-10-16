package io.github.lvgocc.prototype;

import java.util.StringJoiner;

/**
 * 图形原型类
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @date 2020/10/16 15:53
 */
public class Graphics implements Cloneable {

    private String color;
    private String shape;
    private Size size;


    public Graphics(String color, String shape, Size size) {
        this.color = color;
        this.shape = shape;
        this.size = size;
    }

    @Override
    protected Graphics clone() throws CloneNotSupportedException {
        return (Graphics) super.clone();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Graphics.class.getSimpleName() + "[", "]")
                .add("color='" + color + "'")
                .add("shape='" + shape + "'")
                .add("size=" + size)
                .toString();
    }
}
