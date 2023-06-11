package com.andyadc.seckill.starter.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@ComponentScan(value = {"com.andyadc.seckill"})
@Configuration
@Import({RedisConfig.class})
public class SeckillConfig {
}
