package io.github.lvgocc.strategy.jdk;

import java.util.Comparator;

/**
 * TestJDKComparator JDK 的比较器相关测试
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/22
 */
public class TestJDKComparator {

    public static void main(String[] args) {
        String you = "你";
        String fine = "好";
        // String 的比较器
        int ctic = you.compareToIgnoreCase(fine);
        System.out.println("compareToIgnoreCase:" + ctic);

        // JDK 提供的默认比较器
        Comparator<String> comparator = Comparator.naturalOrder();
        int compare = comparator.compare(you, fine);
        System.out.println("naturalOrder = " + compare);

        // 自定义比较器1
        Comparator<String> stringComparator1 = Comparator.nullsFirst((o1, o2) -> {
            byte[] bytes1 = o1.getBytes();
            byte[] bytes2 = o2.getBytes();
            return bytes1.length - bytes2.length;

        });
        int compare1 = stringComparator1.compare(you, fine);
        System.out.println("nullsFirst&customComparator1 = " + compare1);

        // 自定义比较器2
        Comparator<String> stringComparator2 = Comparator.nullsFirst((o1, o2) -> {
            int length1 = o1.length();
            int length2 = o2.length();
            int min = Math.min(length1, length2);
            for (int i = 0; i < min; i++) {
                char o1Char = o1.charAt(i);
                char o2Char = o2.charAt(i);
                if (o1Char != o2Char) {
                    return o2Char - o1Char;
                }
            }
            return length2 - length1;
        });
        int compare2 = stringComparator2.compare(you, fine);
        System.out.println("nullsFirst&customComparator2 = " + compare2);
    }
}
