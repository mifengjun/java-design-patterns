package io.github.lvgocc.flyweight.lolarms;

/**
 * 欢迎跟我一起学习，公众号搜索：星尘的一个朋友
 * 也可以加我微信（lvgocc）拉你进群
 * <p>
 * 炮车
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/10
 */
public class PaoChe extends Arms {
    public PaoChe(String redOrBlue) {
        super(redOrBlue);
    }

    @Override
    protected void attack() {
        System.out.println(isBlue() ? "蓝" : "红" + "方炮车发射了一颗导弹，轰！");
    }
}
