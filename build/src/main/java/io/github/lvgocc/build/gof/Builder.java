package io.github.lvgocc.build.gof;

/**
 * 抽象构建者
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/17 22:45
 * @since 1.0.0
 */
public abstract class Builder {

    protected PlayerRole playerRole = new PlayerRole();

    abstract void setHairColor();

    abstract void setShape();

    abstract void setSkinColour();

    PlayerRole build() {
        return playerRole;
    }
}
