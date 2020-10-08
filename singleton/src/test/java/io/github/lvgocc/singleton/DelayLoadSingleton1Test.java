package io.github.lvgocc.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
        Assertions.assertSame(instance1, instance2);
    }

    /**
     * 与 多线程创建不同对象测试冲突，保留一个
     */
    //@Test
    void DelayLoadSingleton1() {
        Class<DelayLoadSingleton1> singletonClass = DelayLoadSingleton1.class;
        Assertions.assertThrows(InvocationTargetException.class, () -> {
            Constructor<DelayLoadSingleton1> declaredConstructor = singletonClass.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            declaredConstructor.newInstance();
        });
    }

    @Test
    void multipleBean() throws InterruptedException {
        final List<DelayLoadSingleton1> delayLoadSingleton1s = Collections.synchronizedList(new ArrayList<>());
        int i = 0;
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        while (i < 10) {
            new Thread(() -> {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                delayLoadSingleton1s.add(DelayLoadSingleton1.getInstance());
            }).start();
            i++;
        }
        Thread.sleep(1000);
        final DelayLoadSingleton1 instance = DelayLoadSingleton1.getInstance();
        final List<DelayLoadSingleton1> expected = delayLoadSingleton1s.stream().filter(e -> instance == e).collect(Collectors.toList());
        // 这里预期结果应该是小于原数组大小
        Assertions.assertTrue(delayLoadSingleton1s.size() >= expected.size());
    }


    @Test
    void readResolve() {
        DelayLoadSingleton1 instance = DelayLoadSingleton1.getInstance();

        try (FileOutputStream fileOutputStream = new FileOutputStream(DelayLoadSingleton1.class.getResource("").getPath() + "singleton.txt");
             final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(instance);
            final ObjectInputStream objectInputStream = new ObjectInputStream(DelayLoadSingleton1.class.getResourceAsStream("singleton.txt"));
            final DelayLoadSingleton1 o = (DelayLoadSingleton1) objectInputStream.readObject();
            Assertions.assertEquals(instance, o);
        } catch (IOException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
