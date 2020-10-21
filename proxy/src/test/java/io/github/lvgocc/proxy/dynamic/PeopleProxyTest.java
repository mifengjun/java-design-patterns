package io.github.lvgocc.proxy.dynamic;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * //TODO 一句话描述此类的作用
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/21 22:57
 * @since 1.0.0
 */
class PeopleProxyTest {

    @Test
    void invoke() {
        People o = (People) Proxy.newProxyInstance(People.class.getClassLoader(), new Class[]{People.class}, (proxy, method, args) -> {
            System.out.println(Arrays.toString(args));
            System.out.println(method.getName());
            System.out.println(method.getDeclaringClass().getCanonicalName());
            return null;
        });
        o.read();
        o.write("123");
    }
}
