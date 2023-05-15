package com.andyadc.seckill.application.service;

import com.andyadc.seckill.domain.model.SeckillUser;

public interface SeckillUserService {

    SeckillUser getSeckillUserByUsername(String username);
}
