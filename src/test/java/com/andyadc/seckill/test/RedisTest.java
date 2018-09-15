package com.andyadc.seckill.test;

import com.andyadc.seckill.redis.UserKey;
import org.junit.Test;

/**
 * @author andy.an
 * @since 2018/9/15
 */
public class RedisTest {

    @Test
    public void testPrefix() {
        UserKey userKey = UserKey.idKey;
        System.out.println(userKey.prefix());

    }
}
