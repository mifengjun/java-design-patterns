package io.github.lvgocc.factory.simple;

/**
 * 图形工厂
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/8 22:05
 * @since 1.0.0
 */
public class GraphicalFactory {

    public static final int CIRCULAR = 0;
    public static final int RECTANGLE = 1;
    public static final int TRIANGLE = 2;


    public static Graphical create(int type) {
        switch (type) {
            case CIRCULAR:
                return new Circular();
            case RECTANGLE:
                return new Rectangle();
            case TRIANGLE:
                return new Triangle();
            default:
                throw new IllegalStateException("please check param， range 0 - 2");
        }
    }
}
