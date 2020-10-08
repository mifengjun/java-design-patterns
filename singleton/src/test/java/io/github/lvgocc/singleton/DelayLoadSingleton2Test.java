package io.github.lvgocc.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.Collectors;

/**
 * 延迟加载模式1（懒汉式）test
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/8 19:12
 * @since 1.0.0
 */
class DelayLoadSingleton2Test {

    @Test
    void getInstance() {
        final DelayLoadSingleton2 instance1 = DelayLoadSingleton2.getInstance();
        final DelayLoadSingleton2 instance2 = DelayLoadSingleton2.getInstance();
        Assertions.assertSame(instance1, instance2);
    }

    @Test
    void multipleBean() throws InterruptedException {
        final List<DelayLoadSingleton2> DelayLoadSingleton2s = Collections.synchronizedList(new ArrayList<>());
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
                DelayLoadSingleton2s.add(DelayLoadSingleton2.getInstance());
            }).start();
            i++;
        }
        Thread.sleep(3000);
        final DelayLoadSingleton2 instance = DelayLoadSingleton2.getInstance();
        final List<DelayLoadSingleton2> expected = DelayLoadSingleton2s.stream().filter(e -> instance == e).collect(Collectors.toList());
        Assertions.assertEquals(DelayLoadSingleton2s.size(), expected.size());
    }


    @Test
    void readResolve() {
        DelayLoadSingleton2 instance = DelayLoadSingleton2.getInstance();

        try (FileOutputStream fileOutputStream = new FileOutputStream(DelayLoadSingleton2.class.getResource("").getPath() + "DelayLoadSingleton2.txt");
             final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(instance);
            final ObjectInputStream objectInputStream = new ObjectInputStream(DelayLoadSingleton2.class.getResourceAsStream("DelayLoadSingleton2.txt"));
            final DelayLoadSingleton2 o = (DelayLoadSingleton2) objectInputStream.readObject();
            Assertions.assertEquals(instance, o);
        } catch (IOException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
