package com.andyadc.seckill.domain.repository;

import com.andyadc.seckill.domain.model.SeckillUser;

public interface SeckillUserRepository {

    SeckillUser getSeckillUserByUsername(String username);
}
