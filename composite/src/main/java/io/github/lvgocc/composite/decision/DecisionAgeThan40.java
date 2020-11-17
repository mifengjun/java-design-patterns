package io.github.lvgocc.composite.decision;

/**
 * 决策部分 - 年龄 大于 40 岁
 * <p>
 * 欢迎跟我一起学习，公众号搜索：星尘的一个朋友
 * 也可以加我微信（lvgocc）拉你进群
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/17
 */
public class DecisionAgeThan40 extends DecisionComponent {

    public DecisionAgeThan40(String name) {
        super(name);
    }

    @Override
    protected boolean judge(User user) {
        return 40 <= user.getAge();
    }

    @Override
    protected void add(DecisionComponent decisionComponent) {
        decisionComponents.add(decisionComponent);
    }

    @Override
    protected void remove(DecisionComponent decisionComponent) {
        decisionComponents.remove(decisionComponent);
    }
}
