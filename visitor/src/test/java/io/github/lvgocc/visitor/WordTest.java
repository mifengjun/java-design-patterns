package io.github.lvgocc.visitor;

import org.junit.jupiter.api.Test;

/**
 * WordTest
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/12/2
 */
class WordTest {

    @Test
    void accept() {
        Word word = new Word();
        word.addWord(new Versailles());
        word.addWord(new FiveTiaoRen());

        word.accept(new I());
        System.out.println();
        word.accept(new MyFriend());
        System.out.println();
        word.accept(new You());
        System.out.println();
    }
}