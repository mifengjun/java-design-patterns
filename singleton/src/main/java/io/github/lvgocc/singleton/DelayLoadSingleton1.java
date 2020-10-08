package io.github.lvgocc.singleton;

import java.io.Serializable;

/**
 * 延迟加载模式1（懒汉式）
 * 线程不安全, 会出现多个实例
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/6 13:11
 * @since 1.0.0
 */
public class DelayLoadSingleton1 implements Serializable {

    private static DelayLoadSingleton1 delayLoadSingleton1;

    private DelayLoadSingleton1() {
        // 测试多线程并发时可能创建多个实例注释
        // 解决反射创建对象破解单例模式
//        if (delayLoadSingleton1 != null) {
//            throw new IllegalStateException("Already initialized");
//        }
    }

    public static DelayLoadSingleton1 getInstance() {
        if (delayLoadSingleton1 == null) {
            delayLoadSingleton1 = new DelayLoadSingleton1();
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
