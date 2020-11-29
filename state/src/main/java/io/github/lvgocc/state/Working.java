package io.github.lvgocc.state;

/**
 * Working 状态模式上下文环境
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/29
 */
public class Working {
    /**
     * 当前工作状态
     */
    private WorkState concurrentState;

    /**
     * 当前时刻
     */
    private int clock;

    public Working(WorkState concurrentState) {
        this.concurrentState = concurrentState;
    }

    public void writeCode() {
        concurrentState.handle(this);
    }

    public WorkState getConcurrentState() {
        return concurrentState;
    }

    public void setConcurrentState(WorkState concurrentState) {
        this.concurrentState = concurrentState;
    }

    public int getClock() {
        return clock;
    }

    public void setClock(int clock) {
        this.clock = clock;
    }
}
