package io.github.lvgocc.factory.method;

import io.github.lvgocc.factory.util.ThreadUtil;

/**
 * 圆形工厂
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/8 23:27
 * @since 1.0.0
 */
public class CircularFactory extends AbstractGraphicalFactory {
    /**
     * 将创建复杂的圆形过程封装到工厂里。
     * 1. 选定圆形位置；
     * 2. 指定圆形半径；
     * 3. 设置绘制图形所用的画笔；
     * 4. 选择图形的颜色；
     * 5. 。。。。。
     *
     * @return 一个复杂的圆形
     */
    @Override
    public Graphical creat() {
        logger.info("正在选取圆形位置。。。。");
        ThreadUtil.sleep(0.5);
        logger.info("正在指定圆形半径。。。。");
        ThreadUtil.sleep(0.9);
        logger.info("正在设置绘制图形所用的画笔。。。。");
        ThreadUtil.sleep(0.5);
        logger.info("正在选择图形的颜色。。。。");
        ThreadUtil.sleep(0.8);
        logger.info("正在绘制。。。。");
        ThreadUtil.sleep(1.5);
        logger.info("绘制完成。。。。");
        return new Circular();
    }
}
