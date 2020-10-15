package io.github.lvgocc.abstractfactory;

/**
 * 苹果手机
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @date 2020/10/15 18:17
 */
public class IPhone extends Phone {
    @Override
    void launch() {
        System.out.println("iphone is launched");
    }
}
