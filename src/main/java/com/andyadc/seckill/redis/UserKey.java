package com.andyadc.seckill.redis;

/**
 * @author andaicheng
 * @since 2018/9/2
 */
public class UserKey extends BasePrefix {

    public static UserKey idKey = new UserKey("id", 30);
    public static UserKey nameKey = new UserKey("name", 30);

    public UserKey(String prefix) {
        super(prefix);
    }

    public UserKey(String prefix, int expire) {
        super(prefix, expire);
    }
}
