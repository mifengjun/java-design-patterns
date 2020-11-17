package io.github.lvgocc.composite.decision;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 决策组件
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
public abstract class DecisionComponent {

    protected String name;
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected List<DecisionComponent> decisionComponents = new ArrayList<>();

    public DecisionComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 决策
     *
     * @param user 用户信息
     * @return 决策结果
     */
    protected DecisionComponent decision(User user) {
        if (judge(user)) {
            logger.info("进入 {} 决策分支", getName());
            for (DecisionComponent decisionComponent : decisionComponents) {
                if (decisionComponent.judge(user)) {
                    return decisionComponent.decision(user);
                }
            }
        }
        return null;
    }


    protected abstract boolean judge(User user);

    protected abstract void add(DecisionComponent decisionComponent);

    protected abstract void remove(DecisionComponent decisionComponent);
}
