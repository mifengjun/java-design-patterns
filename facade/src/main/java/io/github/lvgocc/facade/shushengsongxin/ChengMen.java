package io.github.lvgocc.facade.shushengsongxin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 书生送信 - 城门
 * <p>
 * 欢迎跟我一起学习，公众号搜索：星尘的一个朋友
 * 也可以加我微信（lvgocc）拉你进群
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/2
 */
public class ChengMen {

    static final Logger LOGGER = LoggerFactory.getLogger(ChengMen.class);

    void login() {
        LOGGER.info("登记中....");
    }

    void check() {
        LOGGER.info("检查包裹中....");
    }
}
