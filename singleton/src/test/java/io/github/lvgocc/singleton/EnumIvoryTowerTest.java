package io.github.lvgocc.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * 基于枚举的单例实现  test
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/8 19:21
 * @since 1.0.0
 */
class EnumIvoryTowerTest {

    @Test
    void instance() {
        final EnumIvoryTower instance1 = EnumIvoryTower.INSTANCE;
        final EnumIvoryTower instance2 = EnumIvoryTower.INSTANCE;
        Assertions.assertSame(instance1, instance2);
    }

    @Test
    void EnumIvoryTower() {
        Class<EnumIvoryTower> singletonClass = EnumIvoryTower.class;
        Assertions.assertThrows(NoSuchMethodException.class, () -> {
            Constructor<EnumIvoryTower> declaredConstructor = singletonClass.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            declaredConstructor.newInstance();
        });
    }


    @Test
    void readResolve() {
        EnumIvoryTower instance = EnumIvoryTower.INSTANCE;

        try (FileOutputStream fileOutputStream = new FileOutputStream(EnumIvoryTower.class.getResource("").getPath() + "EnumIvoryTower.txt");
             final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(instance);
            final ObjectInputStream objectInputStream = new ObjectInputStream(EnumIvoryTower.class.getResourceAsStream("EnumIvoryTower.txt"));
            final EnumIvoryTower o = (EnumIvoryTower) objectInputStream.readObject();
            Assertions.assertEquals(instance, o);
        } catch (IOException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
