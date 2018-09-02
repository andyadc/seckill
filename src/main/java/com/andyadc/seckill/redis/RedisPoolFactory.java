package com.andyadc.seckill.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author andaicheng
 * @since 2018/9/2
 */
@Configuration
public class RedisPoolFactory {

    private static final Logger logger = LoggerFactory.getLogger(RedisPoolFactory.class);

    private RedisConfig redisConfig;

    public RedisPoolFactory(RedisConfig redisConfig) {
        this.redisConfig = redisConfig;
    }

    @Bean
    public JedisPool jedisPoolFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(redisConfig.getMaxIdle());
        poolConfig.setMaxTotal(redisConfig.getMaxTotal());

        JedisPool pool = new JedisPool(poolConfig,
                redisConfig.getHost(),
                redisConfig.getPort(),
                redisConfig.getTimeout() * 1000,
                redisConfig.getPassword(),
                redisConfig.getDatabase()
        );
        logger.info("Build jedis pool success. {}", pool);
        return pool;
    }
}
