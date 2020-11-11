package io.github.lvgocc.flyweight.lolarms;

import java.util.HashMap;
import java.util.Map;

/**
 * 欢迎跟我一起学习，公众号搜索：星尘的一个朋友
 * 也可以加我微信（lvgocc）拉你进群
 * <p>
 * 兵种工厂
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/10
 */
public abstract class ArmsFactory {

    protected static final Map<String, Arms> ARMS_CACHE = new HashMap<>(16);

    public static int getArmsSize() {
        return ARMS_CACHE.size();
    }

    public abstract Arms getArms(ArmsEnum arm);

    protected Arms check(ArmsEnum arm) {
        Arms arms;
        switch (arm) {
            case BUBING:
                arms = createBuBing();
                break;
            case MOFABING:
                arms = createMoFaBing();
                break;
            case PAOCHE:
                arms = createPaoChe();
                break;
            default:
                throw new IllegalArgumentException("argument error");
        }
        return arms;
    }

    protected abstract Arms createBuBing();

    protected abstract Arms createMoFaBing();

    protected abstract Arms createPaoChe();
}
