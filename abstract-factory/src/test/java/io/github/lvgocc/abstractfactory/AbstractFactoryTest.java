package io.github.lvgocc.abstractfactory;

import org.junit.jupiter.api.Test;

class AbstractFactoryTest {


    /**
     * 创建两个工厂，生产两个不同的系列产品
     */
    @Test
    void testAbstractFactory() {
        // 苹果工厂
        AbstractFactory appleFactory = new AppleFactory();
        Phone iphone = appleFactory.createPhone();
        Computer macBook = appleFactory.createComputer();
        iphone.launch();
        macBook.launch();
        System.out.println();
        // 小米工厂
        AbstractFactory miFactory = new MiFactory();
        Phone miPhone = miFactory.createPhone();
        Computer miBook = miFactory.createComputer();
        miPhone.launch();
        miBook.launch();
    }

}