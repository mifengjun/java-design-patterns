package io.github.lvgocc.cor;

/**
 * 上级领导
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/26
 */
public class ShangjiLingdao extends AbstractHandler {
    @Override
    protected void conCreteHandle(String request) {
        System.out.println("上级领导审批：同意");
    }
}
