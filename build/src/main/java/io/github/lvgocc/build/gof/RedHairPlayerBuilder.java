package io.github.lvgocc.build.gof;

/**
 * 红头发角色建造者
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/17 22:58
 * @since 1.0.0
 */
public class RedHairPlayerBuilder extends Builder {
    @Override
    void setHairColor() {
        playerRole.setHairColor("红色");
    }

    @Override
    void setShape() {

    }

    @Override
    void setSkinColour() {

    }
}
