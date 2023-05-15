package com.andyadc.seckill.interfaces.controller;

import com.andyadc.seckill.application.service.SeckillUserService;
import com.andyadc.seckill.domain.model.SeckillUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
@RequestMapping(value = "/seckill/user")
@RestController
public class SeckillUserController {

    private final SeckillUserService seckillUserService;

    @Autowired
    public SeckillUserController(SeckillUserService seckillUserService) {
        this.seckillUserService = seckillUserService;
    }

    @RequestMapping(value = "/get", method = {RequestMethod.GET, RequestMethod.POST})
    public SeckillUser getUser(@RequestParam(value = "username") String username){
        return seckillUserService.getSeckillUserByUsername(username);
    }
}
