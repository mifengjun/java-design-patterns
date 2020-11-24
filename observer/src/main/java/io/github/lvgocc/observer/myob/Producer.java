package io.github.lvgocc.observer.myob;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 一个简单的 Producer
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/23
 */
public class Producer {

    private final List<Consumer> consumers;

    public Producer() {
        consumers = Collections.synchronizedList(new ArrayList<>());
    }

    public void addConsumer(Consumer consumer) {
        if (!consumers.contains(consumer)) {
            consumers.add(consumer);
        }
    }

    public void notifyConsumer() {
        this.notifyConsumer(null);
    }

    public void notifyConsumer(Object message) {
        consumers.forEach(consumer -> consumer.consume(this, message));
    }
}
