package io.github.lvgocc.interpreter;

/**
 * Wife
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/12/2
 */
public class Wife implements EyeColor {
    @Override
    public synchronized void interpreter(Context context) {
        if (context.getContent().contains("座椅")) {
            System.out.println("生气！");
        } else if (context.getContent().contains("架子")) {
            System.out.println("开心！");
        }
    }
}
