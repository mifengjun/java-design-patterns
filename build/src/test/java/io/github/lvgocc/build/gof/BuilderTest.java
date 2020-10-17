package io.github.lvgocc.build.gof;

import org.junit.jupiter.api.Test;

/**
 * gof builder test
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/17 22:56
 * @since 1.0.0
 */
class BuilderTest {

    @Test
    void build() {
        Builder playerRoleBuilder = new PlayerRoleBuilder();
        Director playerRoleBuildDirector = new Director(playerRoleBuilder);
        PlayerRole construct = playerRoleBuildDirector.construct();
        System.out.println("construct = " + construct);
    }

    @Test
    void redHairBuild() {
        Builder playerRoleBuilder = new RedHairPlayerBuilder();
        Director playerRoleBuildDirector = new Director(playerRoleBuilder);
        PlayerRole construct = playerRoleBuildDirector.construct();
        System.out.println("construct = " + construct);
    }


}
