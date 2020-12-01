package io.github.lvgocc.visitor;

/**
 * You 你是个网络达人
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/12/1
 */
public class You implements Visitor {
    @Override
    public void visit(Versailles versailles) {
        System.out.println(versailles.getInterpretation4());
    }
}
