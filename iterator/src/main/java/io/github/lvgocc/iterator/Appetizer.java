package io.github.lvgocc.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Appetizer 开胃菜
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/26
 */
public class Appetizer {

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        int count = 1000000;
        for (int i = 1; i <= count; i++) {
            strings.add("第" + i + "个元素");
        }

        // "iterator"
        long start = System.currentTimeMillis();

        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long end = System.currentTimeMillis();
        printCost(count, start, end, "iterator");

        // "forEach"
        start = System.currentTimeMillis();
        strings.forEach(t -> {
        });
        end = System.currentTimeMillis();
        printCost(count, start, end, "forEach");

        // "增强 for 循环"
        start = System.currentTimeMillis();
        for (String string : strings) {
            // test speed
//            System.out.println(string);
        }
        end = System.currentTimeMillis();
        printCost(count, start, end, "增强 for 循环");


        // "下标遍历"
        start = System.currentTimeMillis();
        for (int i = 0; i < strings.size(); i++) {
            // test speed
//            System.out.println(strings.get(i));
        }
        end = System.currentTimeMillis();
        printCost(count, start, end, "下标遍历");
    }

    private static void printCost(int count, long start, long end, String function) {
        System.out.printf("测试方法：%s\n测试数据量：%d\n花费时长（ms）：%d\n-----------------------------\n", function, count, end - start);
    }
}
