package io.github.lvgocc.singleton;

import java.io.Serializable;

/**
 * 内部类单例模式
 * 这个模式综合使用了Java的类级内部类和多线程缺省同步锁的知识，
 * 很巧妙地同时实现了延迟加载和线程安全。同时不受jdk版本的影响。
 * <p>
 * 内部类分为对象级别和类级别
 * 类级内部类指的是，有static修饰的成员变量的内部类。
 * 如果没有static修饰的成员变量的内部类被称为对象级内部类。
 * <p>
 * 类级内部类相当于其外部类的static成员，它的对象与外部类对象间不存在依赖关系，相互独立，因此可直接创建。
 * 而对象级内部类的实例，是必须绑定在外部对象实例上的。类级内部类只有在第一次被使用的时候才被会装载。
 * <p>
 * 推荐大家一篇Java内部类学习文章.
 * https://blog.csdn.net/sinat_34344123/article/details/81942427
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/6 14:22
 * @since 1.0.0
 */
public class InnerClassSingleton implements Serializable {

    private InnerClassSingleton() {
        // 解决反射创建对象破解单例模式
        if (InnerClassSingletonBuild.innerClassSingleton != null) {
            throw new IllegalStateException("Already initialized");
        }
    }

    public static InnerClassSingleton getInstance() {
        return InnerClassSingletonBuild.innerClassSingleton;
    }

    private static class InnerClassSingletonBuild {
        private static InnerClassSingleton innerClassSingleton = new InnerClassSingleton();
    }

    /**
     * 解决反序列化创建对象破坏单例模式
     */
    private Object readResolve() {
        return InnerClassSingletonBuild.innerClassSingleton;
    }
}
