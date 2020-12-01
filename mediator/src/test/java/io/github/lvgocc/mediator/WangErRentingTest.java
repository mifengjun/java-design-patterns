package io.github.lvgocc.mediator;

import org.junit.jupiter.api.Test;

/**
 * WangErRentingTest
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/12/1
 */
class WangErRentingTest {

    @Test
    void zuFang() {
        WangErRenting wangErRenting = new WangErRenting();
        String result = wangErRenting.zuFang(1);
        System.out.println("房东一 = " + result);
        result = wangErRenting.zuFang(2);
        System.out.println("房东二 = " + result);
        result = wangErRenting.zuFang(3);
        System.out.println("房东三 = " + result);
    }
}