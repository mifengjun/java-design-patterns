package io.github.lvgocc.interpreter;

/**
 * Context 眼色环境
 * <p>
 * 欢迎跟我一起学习，微信（lvgocc）公众号搜索：星尘的一个朋友
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/12/2
 */
public class Context {
    /**
     * 内容 竖线| 分隔
     */
    private String content;

    public Context(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
