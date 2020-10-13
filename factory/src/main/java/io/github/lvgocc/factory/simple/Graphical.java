package io.github.lvgocc.factory.simple;

/**
 * 抽象图形类
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/8 21:33
 * @since 1.0.0
 */
public abstract class Graphical {
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
