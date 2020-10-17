package io.github.lvgocc.build.lvgo;

/**
 * 游戏角色建造者
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/17 22:45
 * @since 1.0.0
 */
public class PlayerRoleBuilder {

    private final PlayerRole playerRole = new PlayerRole();

    PlayerRoleBuilder hairColor(String color) {
        playerRole.setHairColor(color);
        return this;
    }

    PlayerRoleBuilder shape(String shape) {
        playerRole.setShape(shape);
        return this;
    }

    PlayerRoleBuilder skinColour(String skinColour) {
        playerRole.setSkinColour(skinColour);
        return this;
    }

    PlayerRole build() {
        return playerRole;
    }
}
