package io.github.lvgocc.templatemethod;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

class MutexLockTest {
    private static int f = 0;

    @Test
    void lock() throws InterruptedException {
        Lock lock = new MutexLock();
        int threadCount = Runtime.getRuntime().availableProcessors();
        CountDownLatch signal = new CountDownLatch(threadCount);
        int loop = 100000;
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(() -> {
                int l = 0;
                while (l < loop) {
                    lock.lock();
                    try {
                        f++;
                    } catch (Exception e) {

                    } finally {
                        lock.unlock();
                    }
                    l++;
                }
                signal.countDown();
            });
            thread.start();
        }
        signal.await();
        Assertions.assertEquals(threadCount * loop, f);
    }
}