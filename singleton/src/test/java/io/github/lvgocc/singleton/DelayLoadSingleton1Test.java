package io.github.lvgocc.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.Collectors;

/**
 * 延迟加载模式1（懒汉式）
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/8 18:13
 * @since 1.0.0
 */
class DelayLoadSingleton1Test {

    @Test
    void getInstance() {
        final DelayLoadSingleton1 instance1 = DelayLoadSingleton1.getInstance();
        final DelayLoadSingleton1 instance2 = DelayLoadSingleton1.getInstance();
        Assertions.assertEquals(instance1, instance2);
    }


    @Test
    void multipleBean() throws BrokenBarrierException, InterruptedException {
        final List<DelayLoadSingleton1> delayLoadSingleton1s = Collections.synchronizedList(new ArrayList<DelayLoadSingleton1>());
        int i = 0;
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        while (i < 10) {
            new Thread(() -> {
                try {
                    cyclicBarrier.await();
                    Thread.sleep(1000);
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                delayLoadSingleton1s.add(DelayLoadSingleton1.getInstance());
            }).start();
            i++;
        }
        Thread.sleep(3000);
        final DelayLoadSingleton1 instance = DelayLoadSingleton1.getInstance();
        final List<DelayLoadSingleton1> expected = delayLoadSingleton1s.stream().filter(e -> instance == e).collect(Collectors.toList());
        // 这里预期结果应该是小于原数组大小
        Assertions.assertNotEquals(delayLoadSingleton1s, expected);
    }
}
