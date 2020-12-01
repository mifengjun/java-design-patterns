package io.github.lvgocc.mediator.wangeruzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * HR
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/12/1
 */
public class HR implements Mediator {
    private final List<Colleague> colleagues = new ArrayList<>();

    public void addColleague(Colleague colleague) {
        if (!colleagues.contains(colleague)) colleagues.add(colleague);
    }

    @Override
    public void send(String message, Colleague colleague) {
        Class<? extends Colleague> target = Colleague.class;
        if (WangEr.class.equals(colleague.getClass())) {
            target = DeviceManager.class;
        } else if (DeviceManager.class.equals(colleague.getClass())) {
            target = WangEr.class;
        }
        for (Colleague value : colleagues) {
            if (value.getClass() == target) {
                value.receive(message);
                return;
            }
        }
    }
}
