package io.github.lvgocc.factory.method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 抽象工厂
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/8 23:16
 * @since 1.0.0
 */
public abstract class AbstractFactory {
    Logger logger = LoggerFactory.getLogger(AbstractFactory.class);

    /**
     * 创建一个图形
     *
     * @return 具体图形
     */
    public abstract Graphical creat();
}
