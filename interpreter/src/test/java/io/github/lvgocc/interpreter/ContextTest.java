package io.github.lvgocc.interpreter;

import org.junit.jupiter.api.Test;

/**
 * ContextTest
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/12/2
 */
class ContextTest {

    @Test
    void getType() {
        EyeColor eyeColor = null;
        Context context = new Context("柯镇恶往左摆头 | 老婆坐在了架子上");
        String content = context.getContent();
        String[] strings = content.split("\\|");
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            context.setContent(string);
            if (string.contains("柯镇恶")) {
                eyeColor = new KeZhenE();
            } else if (string.contains("老婆")) {
                eyeColor = new Wife();
            }
            assert eyeColor != null;
            eyeColor.interpreter(context);
        }
    }
}