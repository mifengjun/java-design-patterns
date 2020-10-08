package io.github.lvgocc.factory.method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 图形类接口
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/8 21:33
 * @since 1.0.0
 */
public interface Graphical {
    Logger LOGGER = LoggerFactory.getLogger(Graphical.class);

    /**
     * 图形描述
     */
    void description();
}
