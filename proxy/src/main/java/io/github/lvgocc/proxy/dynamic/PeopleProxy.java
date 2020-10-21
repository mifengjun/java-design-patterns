package io.github.lvgocc.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 人的代理类
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/21 22:55
 * @since 1.0.0
 */
public class PeopleProxy implements InvocationHandler {

    private final People people;

    public PeopleProxy(People people) {
        this.people = people;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        result = method.invoke(people, args);
        return result;
    }
}
