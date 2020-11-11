package io.github.lvgocc.flyweight.lolarms;

import org.junit.jupiter.api.Test;

class ArmsFactoryTest {

    @Test
    void getArms() {
        // 记录当前场上小兵数量
        int armsTotal = 0;

        // 模拟产生几波小兵
        int batch = 10;
        // 蓝方小兵工厂
        ArmsFactory blueArms = new BlueArmsFactory();
        for (int i = 0; i < batch; i++) {
            blueArms.getArms(ArmsEnum.BUBING);
            armsTotal++;
            blueArms.getArms(ArmsEnum.MOFABING);
            armsTotal++;
            blueArms.getArms(ArmsEnum.PAOCHE);
            armsTotal++;
            System.out.println("蓝方第" + i + 1 + "波兵线");
            System.out.println(String.format("当前场上共有 %s 个小兵", armsTotal));
        }


        // 红方小兵工厂
        ArmsFactory redArms = new RedArmsFactory();
        for (int i = 0; i < batch; i++) {
            redArms.getArms(ArmsEnum.BUBING);
            armsTotal++;
            redArms.getArms(ArmsEnum.MOFABING);
            armsTotal++;
            redArms.getArms(ArmsEnum.PAOCHE);
            armsTotal++;
            System.out.println("红方第" + i + 1 + "波兵线");
            System.out.println(String.format("当前场上共有 %s 个小兵", armsTotal));
        }


        System.out.println(String.format("当前享元对象(内存)共有 %s 个小兵", ArmsFactory.getArmsSize()));
    }
}