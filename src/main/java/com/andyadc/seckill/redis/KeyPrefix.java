package com.andyadc.seckill.redis;

/**
 * @author andaicheng
 * @since 2018/9/2
 */
public interface KeyPrefix {

    String prefix();

    /**
     * @return seconds
     */
    int expire();
}
