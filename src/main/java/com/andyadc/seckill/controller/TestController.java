package com.andyadc.seckill.controller;

import com.andyadc.seckill.exception.SeckillException;
import com.andyadc.seckill.redis.RedisService;
import com.andyadc.seckill.redis.UserKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author andaicheng
 * @since 2018/9/2
 */
@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/ex/sys")
    public Object sysEx() {
        return 1 / 0;
    }

    @RequestMapping("/ex/sec")
    public Object sysSec() {
        throw new SeckillException("123", "Params error");
    }

    @RequestMapping("/redis/set")
    public Object set(HttpServletRequest request) {
        return redisService.set(UserKey.idKey,
                request.getParameter("key"),
                request.getParameter("value"));
    }

    @RequestMapping("/redis/get")
    public String get(HttpServletRequest request) {
        return redisService.get(UserKey.idKey, request.getParameter("key"));
    }
}
