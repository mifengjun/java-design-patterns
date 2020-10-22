package io.github.lvgocc.proxy.dynamic;

/**
 * 用户接口
 *
 * @author lvgorice@gmail.com
 * @date 2020/10/21 22:51
 * @since 1.0.0
 */
public interface UserMapper {

    /**
     * 查询
     *
     * @param id 用户id
     * @return 用户 toString
     */
    String selectByUserId(int id);
}
