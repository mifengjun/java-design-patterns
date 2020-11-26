package io.github.lvgocc.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 存档对象管理员
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/26
 */
public class GameMementoCaretaker {

    private final List<GameMemento> gameMementos;

    public GameMementoCaretaker() {
        this.gameMementos = new ArrayList<>();
    }

    public GameMemento getGameMemento(String version) {
        for (GameMemento gameMemento : gameMementos) {
            if (gameMemento.getVersion().equals(version)) {
                System.out.println("读档成功!");
                return gameMemento;
            }
        }
        return null;
    }

    public void setGameMementos(GameMemento gameMemento) {
        if (gameMemento != null) {
            gameMementos.add(gameMemento);
        }
        System.out.println("存档成功!");
    }
}
