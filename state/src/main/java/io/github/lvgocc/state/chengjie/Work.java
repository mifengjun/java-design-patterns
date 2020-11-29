package io.github.lvgocc.state.chengjie;

/**
 * Work 上班工作
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/29
 */
public class Work {

    static int clock;

    public static void main(String[] args) {
        // 上午 9 点
        clock = 9;
        writeCode();
        // 中午 12 点
        clock = 12;
        writeCode();
        // 下午 15 点
        clock = 15;
        writeCode();
        // 晚上 21 点
        clock = 21;
        writeCode();
    }

    public static void writeCode() {
        if (clock < 12) {
            System.out.println("精神抖擞写代码");
        } else if (clock < 13) {
            System.out.println("饿了困了写代码");
        } else if (clock < 17) {
            System.out.println("状态一般写代码");
        } else if (clock < 23) {
            System.out.println("加班疲惫写代码");
        }
    }
}
