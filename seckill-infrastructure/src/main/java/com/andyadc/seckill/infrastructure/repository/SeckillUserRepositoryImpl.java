package com.andyadc.seckill.infrastructure.repository;

import com.andyadc.seckill.domain.model.SeckillUser;
import com.andyadc.seckill.domain.repository.SeckillUserRepository;
import com.andyadc.seckill.infrastructure.mapper.SeckillUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeckillUserRepositoryImpl implements SeckillUserRepository {

    private final SeckillUserMapper seckillUserMapper;

    @Autowired
    public SeckillUserRepositoryImpl(SeckillUserMapper seckillUserMapper) {
        this.seckillUserMapper = seckillUserMapper;
    }

    @Override
    public SeckillUser getSeckillUserByUsername(String username) {
        return seckillUserMapper.getSeckillUserByUserName(username);
    }
}
