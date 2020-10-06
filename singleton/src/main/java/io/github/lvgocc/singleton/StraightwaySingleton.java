package io.github.lvgocc.singleton;

/**
 * 立即加载模式 (饿汉式)
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/6 10:44
 * @since 1.0.0
 */
public class StraightwaySingleton {

    private static StraightwaySingleton straightwaySingleton = new StraightwaySingleton();

    private StraightwaySingleton() {
        // 解决反射创建对象破解单例模式
        if (straightwaySingleton != null) {
            throw new IllegalStateException("Already initialized");
        }
    }

    public static StraightwaySingleton getInstance() {
        return straightwaySingleton;
    }

    /**
     * 解决反序列化创建对象破坏单例模式
     */
    private Object readResolve() {
        return straightwaySingleton;
    }
}
