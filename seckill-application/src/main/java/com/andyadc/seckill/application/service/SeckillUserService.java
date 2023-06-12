package com.andyadc.seckill.application.service;

import com.andyadc.seckill.domain.dto.SeckillUserDTO;
import com.andyadc.seckill.domain.dto.SigninUserDTO;
import com.andyadc.seckill.domain.model.SeckillUser;

public interface SeckillUserService {

    SeckillUser getSeckillUserByUsername(String username);

    boolean signup(SeckillUserDTO seckillUserDTO);

    SigninUserDTO signin(SeckillUserDTO seckillUserDTO);

}
