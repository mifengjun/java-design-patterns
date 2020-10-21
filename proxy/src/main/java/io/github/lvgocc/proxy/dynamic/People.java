package io.github.lvgocc.proxy.dynamic;

/**
 * 人接口，可以写字
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/21 22:51
 * @since 1.0.0
 */
public interface People {

    /**
     * 读
     */
    void read();

    /**
     * 写字
     *
     * @param charset 文字
     */
    void write(String charset);
}
