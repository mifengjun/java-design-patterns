package io.github.lvgocc.cor;

/**
 * AbstractHandler
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/26
 */
public abstract class AbstractHandler {

    protected AbstractHandler next;

    public AbstractHandler getNext() {
        return next;
    }

    public void setNext(AbstractHandler next) {
        this.next = next;
    }

    protected void handle(String request) {
        conCreteHandle(request);
        if (getNext() == null) {
            System.out.println("流程结束");
        } else {
            getNext().handle(request);
        }
    }

    protected abstract void conCreteHandle(String request);
}
