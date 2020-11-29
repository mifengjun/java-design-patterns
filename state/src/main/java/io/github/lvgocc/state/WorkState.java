package io.github.lvgocc.state;

/**
 * WorkState
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/29
 */
public interface WorkState {
    /**
     * 具体的工作情况
     *
     * @param working 工作上下文环境
     */
    void handle(Working working);
}

