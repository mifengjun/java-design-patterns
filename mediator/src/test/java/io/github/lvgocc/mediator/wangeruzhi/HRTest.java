package io.github.lvgocc.mediator.wangeruzhi;

import org.junit.jupiter.api.Test;

/**
 * HRTest
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/12/1
 */
class HRTest {

    @Test
    void send() {
        HR hr = new HR();
        DeviceManager deviceManager = new DeviceManager(hr);
        hr.addColleague(deviceManager);
        WangEr wangEr = new WangEr(hr);
        hr.addColleague(wangEr);
        WangZai wangZai = new WangZai(hr);
        hr.addColleague(wangZai);

        wangEr.send("我没有电脑");
        deviceManager.send("设备管理员下发一台电脑");
    }
}