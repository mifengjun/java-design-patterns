package io.github.lvgocc.singleton;

/**
 * 基于枚举的单例实现 Effective Java 2nd Edition (Joshua Bloch) p. 18
 * <p>
 * This implementation is thread safe, however adding any other method and its thread safety
 * is developers responsibility.
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/6 15:01
 * @since 1.0.0
 */
public enum EnumIvoryTower {

    /**
     * 实例
     */
    INSTANCE;

    /**
     * 重写 toString() 方法,打印地址信息
     *
     * @return EnumIvoryTower 地址信息
     */
    @Override
    public String toString() {
        return getDeclaringClass().getCanonicalName() + "@" + hashCode();
    }
}
