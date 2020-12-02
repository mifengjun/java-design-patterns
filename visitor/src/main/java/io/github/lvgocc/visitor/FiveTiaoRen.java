package io.github.lvgocc.visitor;

/**
 * FiveTiaoRen
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/12/2
 */
public class FiveTiaoRen extends NetWordLanguage {
    private final String interpretation1 = "一个乐队的名字，参加音乐综艺《乐队的夏天》第二季时，因为队员轻松的态度，幽默的语言等特性，深受观众喜爱。但因为各种原因老被淘汰，所以很多观众都要去投票把五条人捞回来。";
    private final String interpretation2 = "啥？？？";

    public String getInterpretation1() {
        return interpretation1;
    }

    public String getInterpretation2() {
        return interpretation2;
    }

    /**
     * 将该对象提供给访问者访问
     *
     * @param visitor 访问者
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
