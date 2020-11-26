package io.github.lvgocc.memento;

import org.junit.jupiter.api.Test;

/**
 * GameMementoTest
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/26
 */
class GameMementoTest {

    @Test
    void testGameMemento() {
        GameMementoOriginator originator = new GameMementoOriginator();
        GameMementoCaretaker caretaker = new GameMementoCaretaker();

        String currentState = "当前游戏状态：\n血量：103\n体力：33\n精神：28";
        System.out.println(currentState);
        originator.setData(currentState);
        System.out.println("保存游戏。。。。");
        // 存档
        GameMemento memento = originator.createMemento();
        caretaker.setGameMementos(memento);
        System.out.println("-------------------------------");

        // 当前游戏状态
        currentState = "当前游戏状态：\n血量：0\n体力：14\n精神：5\nyou deaded！";
        System.out.println(currentState);
        originator.setData(currentState);

        System.out.println("-------------------------------");

        System.out.println("开始回档。。。");
        // 读档
        originator.restoreMemento(caretaker.getGameMemento(memento.getVersion()));
        System.out.println(originator.getData());
    }
}