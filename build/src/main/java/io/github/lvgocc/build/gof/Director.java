package io.github.lvgocc.build.gof;

/**
 * 游戏角色构建指挥者
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/17 22:44
 * @since 1.0.0
 */
public class Director {

    private final Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public PlayerRole construct() {
        builder.setHairColor();
        builder.setShape();
        builder.setSkinColour();
        return builder.build();
    }

    public PlayerRole construct2() {
        builder.setHairColor();
        return builder.build();
    }

    public PlayerRole construct3() {
        builder.setSkinColour();
        return builder.build();
    }
}
