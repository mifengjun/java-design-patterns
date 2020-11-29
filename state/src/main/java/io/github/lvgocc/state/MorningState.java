package io.github.lvgocc.state;

/**
 * MorningState
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/29
 */
public class MorningState implements WorkState {
    @Override
    public void handle(Working working) {
        if (working.getClock() < 12) {
            System.out.println("精神抖擞写代码");
        } else {
            working.setConcurrentState(new NoonState());
            working.writeCode();
        }
    }
}
