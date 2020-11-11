package io.github.lvgocc.flyweight.lolarms;

/**
 * 欢迎跟我一起学习，公众号搜索：星尘的一个朋友
 * 也可以加我微信（lvgocc）拉你进群
 * <p>
 * 红方兵种工厂
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/10
 */
public class RedArmsFactory extends ArmsFactory {
    @Override
    protected Arms createBuBing() {
        System.out.println("创建一个红方步兵");
        return new BuBing("red");
    }

    @Override
    protected Arms createMoFaBing() {
        System.out.println("创建一个红方魔法兵");
        return new MoFaBing("red");
    }

    @Override
    protected Arms createPaoChe() {
        System.out.println("创建一个红方炮车");
        return new PaoChe("red");
    }


    @Override
    public Arms getArms(ArmsEnum arm) {
        Arms arms = ARMS_CACHE.get("red" + arm.name());
        if (arms == null) {
            arms = super.check(arm);
            ARMS_CACHE.put("red" + arm.name(), arms);
        }
        return arms;
    }
}
