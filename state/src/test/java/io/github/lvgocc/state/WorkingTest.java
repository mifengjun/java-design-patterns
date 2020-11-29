package io.github.lvgocc.state;

import org.junit.jupiter.api.Test;

/**
 * WorkingTest
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/29
 */
class WorkingTest {

    @Test
    void writeCode() {
        Working working = new Working(new MorningState());
        // 手动模拟不同时刻
        working.setClock(9);
        working.writeCode();

        working.setClock(12);
        working.writeCode();

        working.setClock(15);
        working.writeCode();

        working.setClock(21);
        working.writeCode();


        working.setClock(24);
        working.writeCode();
    }
}
