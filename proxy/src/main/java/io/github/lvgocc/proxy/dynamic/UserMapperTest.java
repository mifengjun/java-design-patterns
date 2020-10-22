package io.github.lvgocc.proxy.dynamic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * https://lvgocc.github.io
 * proxy-archetype auto generate
 * <p>
 * Hello World
 * <p>
 * 保存动态代理生成类在测试包不生效，所以放在这里进行测试
 */
public class UserMapperTest {
    private static Logger logger = LoggerFactory.getLogger(UserMapperTest.class);

    public static void main(String[] args) {
        logger.info("Hello World!");
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        UserMapper o = (UserMapper) Proxy.newProxyInstance(
                UserMapper.class.getClassLoader(),
                new Class[]{UserMapper.class},
                (proxy, method, arg) -> {
                    logger.info("statement position: {}, args: {}", method.getDeclaringClass().getCanonicalName() + "#" + method.getName(), Arrays.toString(arg));
                    return "用户id：" + arg[0] + "公众号：星尘的一个朋友，加群一起学习设计模式";
                });
        String user = o.selectByUserId(2333);
        logger.info("查询结果：{}", user);
    }
}
