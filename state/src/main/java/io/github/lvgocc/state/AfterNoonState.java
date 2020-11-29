package io.github.lvgocc.state;

/**
 * AfterNoonState
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/29
 */
public class AfterNoonState implements WorkState {
    @Override
    public void handle(Working working) {
        if (working.getClock() < 17) {
            System.out.println("状态一般写代码");
        } else {
            working.setConcurrentState(new EveningState());
            working.writeCode();
        }
    }
}
