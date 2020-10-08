package io.github.lvgocc.singleton;

import java.io.Serializable;

/**
 * 延迟加载模式1（懒汉式）
 * 线程安全, 仅有1个实例
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/6 13:11
 * @since 1.0.0
 */
public class DelayLoadSingleton2 implements Serializable {

    /**
     * 增加 volatile 修饰，解决变量可见性问题
     */
    private static volatile DelayLoadSingleton2 delayLoadSingleton1;

    private DelayLoadSingleton2() {
        // 解决反射创建对象破解单例模式
        if (delayLoadSingleton1 != null) {
            throw new IllegalStateException("Already initialized");
        }
    }

    /**
     * 方法使用同步锁，同时只能有一个客户端来请求该方法，去创建实例。
     * <p>
     * 如果不使用同步方法，可能会出现两个以上线程同时创建了多个对象，破坏了单例模式，至于线程安全，其实也是说对资源的合理利用。拒绝了重复创建
     */
    public static synchronized DelayLoadSingleton2 getInstance() {
        if (delayLoadSingleton1 == null) {
            delayLoadSingleton1 = new DelayLoadSingleton2();
        }
        return delayLoadSingleton1;
    }

    /**
     * 解决反序列化创建对象破坏单例模式
     */
    private Object readResolve() {
        return delayLoadSingleton1;
    }
}
