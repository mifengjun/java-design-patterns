package io.github.lvgocc.flyweight.lolarms;

import java.util.Objects;

/**
 * 欢迎跟我一起学习，公众号搜索：星尘的一个朋友
 * 也可以加我微信（lvgocc）拉你进群
 * <p>
 * 小兵接口
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/10
 */
public class Arms {
    protected boolean red;
    protected boolean blue;

    public Arms(String redOrBlue) {
        this.red = Objects.equals("red", redOrBlue);
    }

    public boolean isBlue() {
        return !red;
    }

    public boolean isRed() {
        return red;
    }
}
