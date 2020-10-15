package io.github.lvgocc.abstractfactory;

/**
 * 小米工厂
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @date 2020/10/15 18:16
 */
public class MiFactory extends AbstractFactory {
    @Override
    Phone createPhone() {
        return new MiPhone();
    }

    @Override
    Computer createComputer() {
        return new MiBook();
    }
}
