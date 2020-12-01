package io.github.lvgocc.mediator.wangeruzhi;

/**
 * Colleague
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/12/1
 */
public abstract class Colleague {

    protected final Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    protected void send(String message) {
        mediator.send(message, this);
    }

    protected abstract void receive(String str);
}