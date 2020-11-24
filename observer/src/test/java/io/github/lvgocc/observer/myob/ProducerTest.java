package io.github.lvgocc.observer.myob;

import org.junit.jupiter.api.Test;

/**
 * ProducerTest
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/23
 */
class ProducerTest {

    @Test
    void myOb() {
        Producer producer1 = new Producer();
        Producer producer2 = new Producer();
        Consumer1 consumer1 = new Consumer1();
        Consumer2 consumer2 = new Consumer2();

        producer1.addConsumer(consumer1);
        producer1.addConsumer(consumer2);
        producer2.addConsumer(consumer1);
        producer2.addConsumer(consumer2);

        producer1.notifyConsumer("我是生产者1，我现在给你们通知一条消息，收到赶紧去消费掉");
        producer2.notifyConsumer("我是生产者2，我现在给你们通知一条消息，收到赶紧去消费掉");
    }
}