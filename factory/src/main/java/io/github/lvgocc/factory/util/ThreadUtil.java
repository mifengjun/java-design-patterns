package io.github.lvgocc.factory.util;

/**
 * 线程工具
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/8 23:38
 * @since 1.0.0
 */
public class ThreadUtil {

    public static void sleep(double second) {
        try {
            Thread.sleep((long) (second * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
