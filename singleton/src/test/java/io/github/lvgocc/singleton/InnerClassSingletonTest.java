package io.github.lvgocc.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 内部类单例模式 test
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/8 19:23
 * @since 1.0.0
 */
class InnerClassSingletonTest {

    @Test
    void getInstance() {
        final InnerClassSingleton instance1 = InnerClassSingleton.getInstance();
        final InnerClassSingleton instance2 = InnerClassSingleton.getInstance();
        Assertions.assertSame(instance1, instance2);
    }

    @Test
    void InnerClassSingleton() {
        Class<InnerClassSingleton> singletonClass = InnerClassSingleton.class;
        Assertions.assertThrows(InvocationTargetException.class, () -> {
            Constructor<InnerClassSingleton> declaredConstructor = singletonClass.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            declaredConstructor.newInstance();
        });
    }

    @Test
    void readResolve() {
        InnerClassSingleton instance = InnerClassSingleton.getInstance();

        try (FileOutputStream fileOutputStream = new FileOutputStream(InnerClassSingleton.class.getResource("").getPath() + "InnerClassSingleton.txt");
             final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(instance);
            final ObjectInputStream objectInputStream = new ObjectInputStream(InnerClassSingleton.class.getResourceAsStream("InnerClassSingleton.txt"));
            final InnerClassSingleton o = (InnerClassSingleton) objectInputStream.readObject();
            Assertions.assertEquals(instance, o);
        } catch (IOException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
