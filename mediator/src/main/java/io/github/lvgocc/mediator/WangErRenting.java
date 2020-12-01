package io.github.lvgocc.mediator;

/**
 * 王二租房
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/12/1
 */
public class WangErRenting {

    private final FangDong1 fangDong1 = new FangDong1();
    private final FangDong2 fangDong2 = new FangDong2();
    private final FangDong3 fangDong3 = new FangDong3();

    public String zuFang(int number) {
        switch (number) {
            case 1:
                return fangDong1.getHouseInfo();
            case 2:
                return fangDong2.getHouseInfo();
            case 3:
                return fangDong3.getHouseInfo();
            default:
                return "";
        }
    }
}
