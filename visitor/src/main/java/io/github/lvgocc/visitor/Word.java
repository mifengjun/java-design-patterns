package io.github.lvgocc.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Word
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/12/2
 */
public class Word {

    /**
     * 网络语
     */
    private final List<NetWordLanguage> netWordLanguages = new ArrayList<>();

    public void addWord(NetWordLanguage netWordLanguage) {
        if (!netWordLanguages.contains(netWordLanguage)) netWordLanguages.add(netWordLanguage);
    }

    /**
     * 将该对象提供给访问者访问
     *
     * @param visitor 访问者
     */
    public void accept(Visitor visitor) {
        netWordLanguages.forEach(e -> e.accept(visitor));
    }
}
