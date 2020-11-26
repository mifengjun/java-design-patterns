package io.github.lvgocc.memento.optimization;

import java.util.Date;

/**
 * 存档对象
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/26
 */
class GameMemento {
    private String version;
    private Date saveDate;
    private String data;

    GameMemento(String version, String data) {
        this.version = version;
        this.data = data;
        saveDate = new Date();
    }

    String getVersion() {
        return version;
    }

    void setVersion(String version) {
        this.version = version;
    }

    Date getSaveDate() {
        return saveDate;
    }

    void setSaveDate(Date saveDate) {
        this.saveDate = saveDate;
    }

    String getData() {
        return data;
    }

    void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GameMemento{" +
                "saveDate=" + saveDate +
                ", data='" + data + '\'' +
                '}';
    }
}
