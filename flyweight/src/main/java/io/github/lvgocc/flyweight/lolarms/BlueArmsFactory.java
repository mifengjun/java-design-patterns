package io.github.lvgocc.flyweight.lolarms;

/**
 * 欢迎跟我一起学习，公众号搜索：星尘的一个朋友
 * 也可以加我微信（lvgocc）拉你进群
 * <p>
 * 蓝方兵种工厂
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/10
 */
public class BlueArmsFactory extends ArmsFactory {
    @Override
    protected Arms createBuBing() {
        System.out.println("创建一个蓝方步兵");
        return new BuBing("blue");
    }

    @Override
    protected Arms createMoFaBing() {
        System.out.println("创建一个蓝方魔法兵");
        return new MoFaBing("blue");
    }

    @Override
    protected Arms createPaoChe() {
        System.out.println("创建一个蓝方炮车");
        return new PaoChe("blue");
    }

    @Override
    public Arms getArms(ArmsEnum arm) {
        Arms arms = ARMS_CACHE.get("blue" + arm.name());
        if (arms == null) {
            arms = super.check(arm);
            ARMS_CACHE.put("blue" + arm.name(), arms);
        }
        return arms;
    }
}
