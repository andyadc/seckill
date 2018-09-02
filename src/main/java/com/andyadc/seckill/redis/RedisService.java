package com.andyadc.seckill.redis;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author andaicheng
 * @since 2018/9/2
 */
@Service
public class RedisService {

    private static final Logger logger = LoggerFactory.getLogger(RedisService.class);

    private static final String OK = "OK";
    private JedisPool jedisPool;

    public RedisService(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public String ping() {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.ping();
        } finally {
            returnToPool(jedis);
        }
    }

    public String get(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(prefix.prefix() + key);
        } finally {
            returnToPool(jedis);
        }
    }

    public <T> T get(KeyPrefix prefix, String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String value = jedis.get(prefix.prefix() + key);
            return JSON.parseObject(value, clazz);
        } finally {
            returnToPool(jedis);
        }
    }

    public <T> boolean set(KeyPrefix prefix, String key, T t) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String value = JSON.toJSONString(t);
            key = prefix.prefix() + key;
            if (prefix.expire() <= 0) {
                return OK.equals(jedis.set(key, value));
            } else {
                return OK.equals(jedis.setex(key, prefix.expire(), value));
            }
        } finally {
            returnToPool(jedis);
        }
    }

    public boolean exists(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.exists(prefix.prefix() + key);
        } finally {
            returnToPool(jedis);
        }
    }

    private void returnToPool(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
            logger.info("{} closed.", jedis);
        }
    }

}
