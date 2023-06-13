package com.andyadc.seckill.application.service;

import java.util.concurrent.TimeUnit;

public interface RedisService {

    /**
     * 设置缓存并设置超时时间
     */
    void set(String key, Object value, long timeout, TimeUnit unit);

    /**
     * 从缓存获取数据
     */
    Object get(String key);
}
