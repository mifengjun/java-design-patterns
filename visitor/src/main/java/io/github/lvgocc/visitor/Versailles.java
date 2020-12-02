package io.github.lvgocc.visitor;

/**
 * 凡尔赛
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/12/1
 */
public class Versailles extends NetWordLanguage {

    private final String interpretation1 = "凡尔赛是法国巴黎的卫星城以及伊夫林省省会，曾是法兰西王朝的行政中心。";
    private final String interpretation2 = "《凡尔赛》是皮埃尔·苏勒执导的剧情片。";
    private final String interpretation3 = "以法国路易十四为时代背景的电视剧。";
    private final String interpretation4 = "凡尔赛文学，网络热词，指通过先抑后扬、自问自答或第三人称视角，不经意间露出\"贵族生活的线索\"。";
    private final String interpretation5 = "啥？？？";

    public String getInterpretation1() {
        return interpretation1;
    }

    public String getInterpretation2() {
        return interpretation2;
    }

    public String getInterpretation3() {
        return interpretation3;
    }

    public String getInterpretation4() {
        return interpretation4;
    }

    public String getInterpretation5() {
        return interpretation5;
    }

    /**
     * 将该对象提供给访问者访问
     *
     * @param visitor 访问者
     */
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
