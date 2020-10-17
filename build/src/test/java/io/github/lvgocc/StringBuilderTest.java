package io.github.lvgocc;

import org.junit.jupiter.api.Test;

/**
 * 演示 stringbuilder
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/17 20:33
 * @since 1.0.0
 */
public class StringBuilderTest {
    @Test
    void test() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1).append("个张三，和").append(4).append("个李四");
        System.out.println(stringBuilder.toString());
    }
}
