package io.github.lvgocc.build.lvgo;

import org.junit.jupiter.api.Test;

/**
 * lvgo 建造者 测试
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/17 23:08
 * @since 1.0.0
 */
class PlayerRoleTest {

    @Test
    void test() {
        PlayerRoleBuilder playerRoleBuilder = new PlayerRoleBuilder();
        playerRoleBuilder.hairColor("红色").shape("健硕").skinColour("古铜色");
        PlayerRole build = playerRoleBuilder.build();
        System.out.println("build = " + build);
    }
}
