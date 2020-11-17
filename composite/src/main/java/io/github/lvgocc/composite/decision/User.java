package io.github.lvgocc.composite.decision;

/**
 * 决策树中使用的用户信息
 * <p>
 * 欢迎跟我一起学习，公众号搜索：星尘的一个朋友
 * 也可以加我微信（lvgocc）拉你进群
 *
 * @author lvgorice@gmail.com
 * @version 1.0
 * @blog @see http://lvgo.org
 * @CSDN @see https://blog.csdn.net/sinat_34344123
 * @date 2020/11/17
 */
public class User {

    private Gender gender;
    private int age;
    private Object more;

    public User(Gender gender, int age) {
        this.gender = gender;
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Object getMore() {
        return more;
    }

    public void setMore(Object more) {
        this.more = more;
    }
}
