package io.github.lvgocc.state;

/**
 * EveningState
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/29
 */
public class EveningState implements WorkState {
    @Override
    public void handle(Working working) {
        if (working.getClock() < 23) {
            System.out.println("加班疲惫写代码");
        } else {
            working.setConcurrentState(work -> {
                System.out.println("别再写了，程序员回家了，明早再试吧😢，现在都已经" + work.getClock() + "点了。放过他吧");
            });
            working.writeCode();
        }
    }
}
