package io.github.lvgocc.build.gof;

/**
 * 游戏角色建造者
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/17 22:46
 * @since 1.0.0
 */
public class PlayerRoleBuilder extends Builder {
    @Override
    void setHairColor() {
        playerRole.setHairColor("褐色");
    }

    @Override
    void setShape() {
        playerRole.setShape("健硕");
    }

    @Override
    void setSkinColour() {
        playerRole.setSkinColour("古铜色");
    }
}
