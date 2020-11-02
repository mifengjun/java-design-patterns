package io.github.lvgocc.facade.shushengsongxin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 书生送信 - 书童
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
public class ShuTong {

    static final Logger LOGGER = LoggerFactory.getLogger(ShuTong.class);
    private ChengMen chengMen = new ChengMen();
    private LaoFuQin laoFuQin = new LaoFuQin();

    void run() {
        LOGGER.info("赶路中...");
    }

    void songXin() {
        chengMen.login();
        chengMen.check();
        run();
        laoFuQin.read();
        laoFuQin.write();
        run();
        chengMen.login();
        chengMen.check();
    }
}
