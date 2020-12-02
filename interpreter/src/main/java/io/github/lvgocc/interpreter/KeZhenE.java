package io.github.lvgocc.interpreter;

/**
 * KeZhenE
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/12/2
 */
public class KeZhenE implements EyeColor {
    @Override
    public void interpreter(Context context) {
        if (context.getContent().contains("左摆头")) {
            System.out.println("冲！");
        } else if (context.getContent().contains("右摆头")) {
            System.out.println("撤！");
        }
    }
}
