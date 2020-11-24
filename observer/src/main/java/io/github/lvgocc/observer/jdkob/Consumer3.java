package io.github.lvgocc.observer.jdkob;

import java.util.Observable;
import java.util.Observer;

/**
 * Consumer
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/23
 */
public class Consumer3 implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("我是 consumer3 我收到了" + o + "的通知，通知内容：" + arg);
    }
}
