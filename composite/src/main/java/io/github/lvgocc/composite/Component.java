package io.github.lvgocc.composite;

/**
 * 欢迎跟我一起学习，公众号搜索：星尘的一个朋友
 * 也可以加我微信（lvgocc）拉你进群
 * <p>
 * 抽象接口
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/12
 */
public abstract class Component {

    protected String name;


    public Component(String name) {
        this.name = name;
    }

    /**
     * 增加一个树枝
     *
     * @param component
     */
    public abstract void add(Component component);

    /**
     * 删除一个树枝
     *
     * @param component
     */
    public abstract void remove(Component component);

    /**
     * 展示当前数结构
     *
     * @param depth
     */
    public abstract void display(int depth);


}
