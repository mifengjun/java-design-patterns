package io.github.lvgocc.observer.myob;

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
public class Consumer1 implements Consumer {

    /**
     * 消费
     *
     * @param producer 生产者
     * @param message  消息
     */
    public void consume(Producer producer, Object message) {
        System.out.println("我是 consumer1 我收到了" + producer + "的通知，通知内容：" + message);
    }
}
