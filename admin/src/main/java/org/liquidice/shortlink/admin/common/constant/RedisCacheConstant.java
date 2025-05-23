package org.liquidice.shortlink.admin.common.constant;

/**
 * 短链接后管 Redis缓存常量
 */
public class RedisCacheConstant {

    /**
     * 用户注册分布式锁
     */
    public static final String LOCK_USER_REGISTER_KEY = "shortlink:lock_user-register";

    /**
     * 分组创建分布式锁
     */
    public static final String LOCK_GROUP_CREATE_KEY = "shortlink:lock_group-create:%s";

    /**
     * 用户登入缓存标识
     */
    public static final String USER_LOGIN_KEY = "shortlink:login:";
}
