package io.github.lvgocc.composite.decision;

/**
 * 决策部分 - 年龄 20 - 30 之间
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
public class DecisionAgeAmong20and30 extends DecisionComponent {
    public DecisionAgeAmong20and30(String name) {
        super(name);
    }

    @Override
    protected boolean judge(User user) {
        return 20 <= user.getAge() && user.getAge() < 30;
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
