package io.github.lvgocc.adapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 日期工具类
 * <p>
 * 欢迎跟我一起学习，公众号搜索：星尘的一个朋友
 * 也可以加我微信（lvgocc）拉你进群
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/10/29
 */
public class DateUtil {

    public final static String YYYY_MM_DD = "yyyy-MM-dd";
    public final static String YYYY_MM_DD_TIGHT = "yyyyMMdd";

    public static String getTightDate(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        SimpleDateFormat df = new SimpleDateFormat(YYYY_MM_DD_TIGHT, Locale.CHINA);
        return df.format(calendar.getTime());
    }

    public static String format(Date date) {
        if (date == null) {
            return null;
        } else {
            return new SimpleDateFormat(YYYY_MM_DD, Locale.CHINA).format(date);
        }
    }

}
