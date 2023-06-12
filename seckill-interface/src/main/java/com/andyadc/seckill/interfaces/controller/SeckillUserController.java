package com.andyadc.seckill.interfaces.controller;

import com.andyadc.seckill.application.service.SeckillUserService;
import com.andyadc.seckill.domain.dto.SeckillUserDTO;
import com.andyadc.seckill.domain.dto.SigninUserDTO;
import com.andyadc.seckill.domain.model.SeckillUser;
import com.andyadc.seckill.domain.response.ResponseMessage;
import com.andyadc.seckill.domain.response.ResponseMessageBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
@RequestMapping(value = "/user")
@RestController
public class SeckillUserController {

    private final SeckillUserService seckillUserService;

    public SeckillUserController(SeckillUserService seckillUserService) {
        this.seckillUserService = seckillUserService;
    }

    @RequestMapping(value = "/signin", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseMessage<SigninUserDTO> signin(@RequestBody SeckillUserDTO seckillUserDTO) {
        return ResponseMessageBuilder.success(seckillUserService.signin(seckillUserDTO));
    }

    @RequestMapping(value = "/signup", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseMessage<Boolean> signup(@RequestBody SeckillUserDTO seckillUserDTO) {
        return ResponseMessageBuilder.success(seckillUserService.signup(seckillUserDTO));
    }

    @RequestMapping(value = "/signout", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseMessage<SeckillUser> signout(@RequestParam(value = "username") String username) {
        return ResponseMessageBuilder.success(seckillUserService.getSeckillUserByUsername(username));
    }

    @RequestMapping(value = "/get", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseMessage<SeckillUser> getUser(@RequestParam(value = "username") String username) {
        return ResponseMessageBuilder.success(seckillUserService.getSeckillUserByUsername(username));
    }
}
