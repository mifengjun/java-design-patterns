package io.github.lvgocc.visitor;

import org.junit.jupiter.api.Test;

/**
 * VisitorTest
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/12/1
 */
class VisitorTest {

    @Test
    void visit() {
        Versailles versailles = new Versailles();

        System.out.println("lvgo 你知道凡尔赛吗？");
        versailles.accept(new I());

        System.out.println("\n狗哥 你知道凡尔赛吗？");
        versailles.accept(new MyFriend());

        System.out.println("\n你知道凡尔赛吗？");
        versailles.accept(new You());
    }
}