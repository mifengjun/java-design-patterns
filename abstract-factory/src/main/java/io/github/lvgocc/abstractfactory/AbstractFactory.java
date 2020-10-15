package io.github.lvgocc.abstractfactory;

/**
 * 抽象工厂
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @date 2020/10/15 18:14
 */
public abstract class AbstractFactory {

    /**
     * 生产手机
     *
     * @return 手机
     */
    abstract Phone createPhone();

    /**
     * 生产电脑
     *
     * @return 电脑
     */
    abstract Computer createComputer();
}
