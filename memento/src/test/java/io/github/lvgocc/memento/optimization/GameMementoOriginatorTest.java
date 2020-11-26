package io.github.lvgocc.memento.optimization;

import org.junit.jupiter.api.Test;

/**
 * GameMementoOriginatorTest
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/26
 */
class GameMementoOriginatorTest {

    @Test
    void save() {
        GameMementoOriginator originator = new GameMementoOriginator();
        String currentState = "当前游戏状态：\n血量：103\n体力：33\n精神：28";
        System.out.println(currentState);
        System.out.println("保存游戏。。。。");
        GameMemento memento1 = originator.save(currentState);

        System.out.println("-------------------------------");
        // 当前游戏状态
        currentState = "当前游戏状态：\n血量：10\n体力：24\n精神：55";
        System.out.println(currentState);
        System.out.println("危");

        System.out.println("-------------------------------");
        // 当前游戏状态
        currentState = "当前游戏状态：\n血量：110\n体力：114\n精神：53\n";
        System.out.println(currentState);
        System.out.println("保存游戏。。。。");
        GameMemento memento2 = originator.save(currentState);

        System.out.println("-------------------------------");
        // 当前游戏状态
        currentState = "当前游戏状态：\n血量：64\n体力：74\n精神：93\n";
        System.out.println(currentState);
        System.out.println("保存游戏。。。。");
        GameMemento memento3 = originator.save(currentState);

        System.out.println("-------------------------------");

        // 当前游戏状态
        currentState = "当前游戏状态：\n血量：0\n体力：14\n精神：5\nyou deaded！";
        System.out.println(currentState);

        System.out.println("-------------------------------");
        System.out.println("存档列表");
        originator.showMementos();
        System.out.println("-------------------------------");

        System.out.println("选择第一个存档开始回档。。。");
        originator.restore(memento1.getVersion());
        System.out.println(originator.getData());
    }
}