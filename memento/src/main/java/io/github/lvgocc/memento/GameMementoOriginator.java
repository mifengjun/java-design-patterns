package io.github.lvgocc.memento;

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
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public GameMemento createMemento() {
        return new GameMemento(UUID.randomUUID().toString().replace("-", ""), data);
    }

    public void restoreMemento(GameMemento memento) {
        this.setData(memento.getData());
    }
}
