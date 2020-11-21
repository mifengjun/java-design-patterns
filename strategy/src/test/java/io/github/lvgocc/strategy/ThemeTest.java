package io.github.lvgocc.strategy;

import org.junit.jupiter.api.Test;

/**
 * ThemeTest
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/21
 */
class ThemeTest {

    @Test
    void show() {
        Context context = new Context();
        System.out.println("七彩斑斓的黑");
        context.setTheme(new ColorfulBlack());
        context.show();

        System.out.println("五颜六色的黑");
        context.setTheme(new MotleyBlack());
        context.show();

        System.out.println("绚烂多彩的黑");
        context.setTheme(new SplendidBlack());
        context.show();
    }
}
