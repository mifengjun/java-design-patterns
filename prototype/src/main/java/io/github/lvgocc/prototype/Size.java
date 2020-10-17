package io.github.lvgocc.prototype;

/**
 * 尺寸
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @date 2020/10/16 16:23
 */
public class Size implements Cloneable {
    public int width;
    public int height;

    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    protected Size clone() throws CloneNotSupportedException {
        return (Size) super.clone();
    }

    @Override
    public String toString() {
        return "Size(" + width + ", " + height + ")";
    }
}
