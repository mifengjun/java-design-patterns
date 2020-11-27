package io.github.lvgocc.iterator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * AppetizerTest
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/27
 */
class AppetizerTest {

    @Test
    void appetizerTest() {
        ArrayList<String> strings = new ArrayList<>();
        int count = 410;
        while (true) {
            strings.clear();
            for (int i = 1; i <= count * 10000; i++) {
                strings.add("第" + i + "个元素");
            }

            // "iterator"
            long start = System.currentTimeMillis();

            Iterator<String> iterator = strings.iterator();
            while (iterator.hasNext()) {
                iterator.next();
            }
            long end = System.currentTimeMillis();
            long iteratorCost = end - start;

            // "forEach"
            start = System.currentTimeMillis();
            strings.forEach(t -> {
            });
            end = System.currentTimeMillis();
            long forEachCost = end - start;

            // "增强 for 循环"
            start = System.currentTimeMillis();
            for (String string : strings) {
                // test speed
//            System.out.println(string);
            }
            end = System.currentTimeMillis();
            long forCost = end - start;


            // "下标遍历"
            start = System.currentTimeMillis();
            for (int i = 0; i < strings.size(); i++) {
                // test speed
//            System.out.println(strings.get(i));
            }
            end = System.currentTimeMillis();
            long indexCost = end - start;
            System.out.printf("%dw\t%d\t%d\t%d\t%d\n", count, iteratorCost, forCost, forEachCost, indexCost);
            count += 10;
        }
    }

    @Test
    void appetizerTest10w() {
        ArrayList<String> strings = new ArrayList<>();
        int count = 20;
        for (int i = 1; i <= count * 10000; i++) {
            strings.add("第" + i + "个元素");
        }
        int c = 0;
        while (c < 100) {
            ++c;
            // "iterator"
            long start = System.currentTimeMillis();

            Iterator<String> iterator = strings.iterator();
            while (iterator.hasNext()) {
                iterator.next();
            }
            long end = System.currentTimeMillis();
            long iteratorCost = end - start;

            // "forEach"
            start = System.currentTimeMillis();
            strings.forEach(t -> {
            });
            end = System.currentTimeMillis();
            long forEachCost = end - start;

            // "增强 for 循环"
            start = System.currentTimeMillis();
            for (String string : strings) {
                // test speed
//            System.out.println(string);
            }
            end = System.currentTimeMillis();
            long forCost = end - start;


            // "下标遍历"
            start = System.currentTimeMillis();
            for (int i = 0; i < strings.size(); i++) {
                // test speed
//            System.out.println(strings.get(i));
            }
            end = System.currentTimeMillis();
            long indexCost = end - start;
            System.out.printf("%d次\t%d\t%d\t%d\t%d\n", c, iteratorCost, forCost, forEachCost, indexCost);
            count += 10;
        }
    }
}