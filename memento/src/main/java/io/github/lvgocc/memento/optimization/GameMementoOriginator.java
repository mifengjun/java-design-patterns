package io.github.lvgocc.memento.optimization;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 存档创建者
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/26
 */
public class GameMementoOriginator {

    private final List<GameMemento> gameMementos;
    private String data;

    public GameMementoOriginator() {
        this.gameMementos = new ArrayList<>();
    }

    private GameMemento getGameMemento(String version) {
        for (GameMemento gameMemento : gameMementos) {
            if (gameMemento.getVersion().equals(version)) {
                System.out.println("读档成功!");
                return gameMemento;
            }
        }
        return null;
    }

    private void setGameMementos(GameMemento gameMemento) {
        if (gameMemento != null) {
            gameMementos.add(gameMemento);
        }
        System.out.println("存档成功!");
    }

    public String getData() {
        return data;
    }

    private GameMemento createMemento(String data) {
        return new GameMemento(UUID.randomUUID().toString().replace("-", ""), data);
    }

    public void restore(String version) {
        GameMemento gameMemento = getGameMemento(version);
        if (gameMemento == null) {
            return;
        }
        this.data = gameMemento.getData();
    }

    public GameMemento save(String data) {
        GameMemento memento = createMemento(data);
        setGameMementos(memento);
        return memento;
    }

    public void showMementos() {
        gameMementos.forEach(System.out::println);
    }
}
