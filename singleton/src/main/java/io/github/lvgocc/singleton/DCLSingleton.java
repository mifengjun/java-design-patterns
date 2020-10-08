package io.github.lvgocc.singleton;

import java.io.Serializable;

/**
 * double check lock singleton
 * <p>
 * 双重检查锁单例
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/6 14:09
 * @since 1.0.0
 */
public class DCLSingleton implements Serializable {
    private static volatile DCLSingleton dclSingleton;

    private DCLSingleton() {
        // 解决反射创建对象破解单例模式
        if (dclSingleton != null) {
            throw new IllegalStateException("Already initialized");
        }
    }

    public static DCLSingleton getInstance() {
        // 定义这个局部变量可以提高大约25%的性能🚀 依据:Joshua Bloch "Effective Java, Second Edition", p. 283-284
        DCLSingleton current = dclSingleton;
        // 1️⃣ 第一次检查
        if (dclSingleton == null) {
            // 🔒此时为了保证线程安全,我们不清楚其他线程是否已经实例化该对象,所以将类上锁达到互斥效果
            synchronized (DCLSingleton.class) {
                /*
                 * 再次将实例分配给局部变量并检查它是否由其他某个线程初始化
                 * 当前线程被阻止进入锁定区域。 如果它已初始化，那么我们可以
                 * 返回先前创建的实例，就像上面检查对象是否为空一样。
                 */
                current = dclSingleton;
                // 2️⃣ 第二次检查
                if (dclSingleton == null) {
                    // 如果此时该类还没有被实例化,那么我们就可以安全的实例化一个单例的该对象实例.
                    current = dclSingleton = new DCLSingleton();
                }
            }
        }
        return current;
    }

    /**
     * 解决反序列化创建对象破坏单例模式
     */
    private Object readResolve() {
        return dclSingleton;
    }
}
