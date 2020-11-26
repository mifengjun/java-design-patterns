package io.github.lvgocc.cor;

import org.junit.jupiter.api.Test;

/**
 * AbstractHandlerTest
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/26
 */
class AbstractHandlerTest {

    @Test
    void handle() {
        AbstractHandler qingJia = new QingJia();
        AbstractHandler renShi = new RenShi();
        AbstractHandler shangjiLingdao = new ShangjiLingdao();
        AbstractHandler tongShi = new TongShi();
        AbstractHandler zuZhang = new ZuZhang();

        qingJia.setNext(tongShi);
        tongShi.setNext(zuZhang);
        zuZhang.setNext(shangjiLingdao);
        shangjiLingdao.setNext(renShi);

        qingJia.handle("张三请假");

    }
}