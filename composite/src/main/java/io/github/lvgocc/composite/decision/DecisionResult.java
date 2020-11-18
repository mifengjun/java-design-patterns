package io.github.lvgocc.composite.decision;

import java.util.StringJoiner;

/**
 * 决策结果
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
public class DecisionResult extends DecisionComponent {
    /**
     * 商品类型
     */
    private String type;

    public DecisionResult(String name, String type) {
        super(name);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DecisionResult.class.getSimpleName() + "[", "]")
                .add("type='" + type + "'")
                .toString();
    }

    @Override
    protected DecisionComponent decision(User user) {
        return this;
    }

    @Override
    protected boolean judge(User user) {
        return true;
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
