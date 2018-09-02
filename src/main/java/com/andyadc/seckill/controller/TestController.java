package com.andyadc.seckill.controller;

import com.andyadc.seckill.redis.RedisService;
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

    @RequestMapping("/redis/set")
    public String set(HttpServletRequest request) {
        return redisService.set(request.getParameter("key"),
                request.getParameter("value"));
    }

    @RequestMapping("/redis/get")
    public String get(HttpServletRequest request) {
        return redisService.get(request.getParameter("key"));
    }
}
