package io.github.lvgocc.state.chengjie;

/**
 * Work 面向对象上班工作
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/29
 */
public class OOPWork {

    public static void main(String[] args) {
        Working working = new Working();
        // 上午 9 点
        working.clock = 9;
        working.writeCode();
        // 中午 12 点
        working.clock = 12;
        working.writeCode();
        // 下午 15 点
        working.clock = 15;
        working.writeCode();
        // 晚上 21 点
        working.clock = 21;
        working.writeCode();
    }
}

class Working {
    int clock;

    public void writeCode() {
        if (clock < 12) {
            new MorningState();
        } else if (clock < 13) {
            new NoonState();
        } else if (clock < 17) {
            new AfterNoonState();
        } else if (clock < 23) {
            new EveningState();
        }
    }
}

class MorningState {

    {
        System.out.println("精神抖擞写代码");
    }
}

class NoonState {

    {
        System.out.println("饿了困了写代码");
    }
}

class AfterNoonState {

    {
        System.out.println("状态一般写代码");
    }
}


class EveningState {

    {
        System.out.println("加班疲惫写代码");
    }
}


