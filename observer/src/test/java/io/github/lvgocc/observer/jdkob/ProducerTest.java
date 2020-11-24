package io.github.lvgocc.observer.jdkob;

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
    void jdkOb() {
        Producer producer1 = new Producer();
        producer1.setChanged();
        Producer producer2 = new Producer();
        producer2.setChanged();
        Consumer1 consumer1 = new Consumer1();
        Consumer2 consumer2 = new Consumer2();
        Consumer3 consumer3 = new Consumer3();

        producer1.addObserver(consumer1);
        producer1.addObserver(consumer2);
        producer1.addObserver(consumer3);
        producer2.addObserver(consumer1);
        producer2.addObserver(consumer2);
        producer2.addObserver(consumer3);

        producer1.notifyObservers("我是生产者1，我现在给你们通知一条消息，收到赶紧去消费掉");
        producer2.notifyObservers("我是生产者2，我现在给你们通知一条消息，收到赶紧去消费掉");
    }
}