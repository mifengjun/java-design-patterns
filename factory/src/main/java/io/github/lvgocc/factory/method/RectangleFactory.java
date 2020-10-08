package io.github.lvgocc.factory.method;

import io.github.lvgocc.factory.util.ThreadUtil;

/**
 * 矩形工厂
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/8 23:52
 * @since 1.0.0
 */
public class RectangleFactory extends AbstractFactory {
    /**
     * 通过工厂创建一个复杂的矩形
     *
     * @return 一个复杂的矩形
     */
    @Override
    public Graphical creat() {
        logger.info("正在选取矩形位置。。。。");
        ThreadUtil.sleep(1.5);
        logger.info("正在设置绘制图形所用的画笔。。。。");
        ThreadUtil.sleep(0.5);
        logger.info("正在选择图形的颜色。。。。");
        ThreadUtil.sleep(0.8);
        logger.info("正在绘制。。。。");
        ThreadUtil.sleep(1.5);
        logger.info("绘制完成。。。。");
        return new Rectangle();
    }
}
