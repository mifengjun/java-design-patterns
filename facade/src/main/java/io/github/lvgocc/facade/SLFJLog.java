package io.github.lvgocc.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 欢迎跟我一起学习，公众号搜索：星尘的一个朋友
 * 也可以加我微信（lvgocc）拉你进群
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/10/30
 */
public class SLFJLog {

    static Logger logger = LoggerFactory.getLogger(SLFJLog.class);
    static Logger logger2 = LoggerFactory.getLogger("lalala");

    public static void main(String[] args) {
        logger.info("this is a line log : {}", "tututu");
        logger2.info("this is a line log : {}", "tututu");
    }
}
