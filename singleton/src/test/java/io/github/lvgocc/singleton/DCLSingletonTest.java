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
 * 双重检查锁单例 test
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/8 16:13
 * @since 1.0.0
 */
class DCLSingletonTest {

    @Test
    void getInstance() {
        DCLSingleton instance1 = DCLSingleton.getInstance();
        DCLSingleton instance2 = DCLSingleton.getInstance();
        Assertions.assertEquals(instance1, instance2);
    }

    @Test
    void DCLSingleton() {
        Class<DCLSingleton> dclSingletonClass = DCLSingleton.class;
        Assertions.assertThrows(InvocationTargetException.class, () -> {
            Constructor<DCLSingleton> declaredConstructor = dclSingletonClass.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            declaredConstructor.newInstance();
        });
    }

    @Test
    void readResolve() {
        DCLSingleton instance = DCLSingleton.getInstance();

        try (FileOutputStream fileOutputStream = new FileOutputStream(DCLSingleton.class.getResource("").getPath() + "dclsingleton.txt");
             final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(instance);
            final ObjectInputStream objectInputStream = new ObjectInputStream(DCLSingleton.class.getResourceAsStream("dclsingleton.txt"));
            final DCLSingleton o = (DCLSingleton) objectInputStream.readObject();
            Assertions.assertEquals(instance, o);
        } catch (IOException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
