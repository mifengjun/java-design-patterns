package io.github.lvgocc.abstractfactory;

/**
 * 苹果工厂
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @date 2020/10/15 18:16
 */
public class AppleFactory extends AbstractFactory {
    @Override
    Phone createPhone() {
        return new IPhone();
    }

    @Override
    Computer createComputer() {
        return new MacBook();
    }
}
