package com.andyadc.seckill.infrastructure.repository;

import com.andyadc.seckill.domain.model.SeckillUser;
import com.andyadc.seckill.domain.repository.SeckillUserRepository;
import com.andyadc.seckill.infrastructure.crypto.CryptoUtil;
import com.andyadc.seckill.infrastructure.mapper.SeckillUserMapper;
import org.springframework.stereotype.Component;

@Component
public class SeckillUserRepositoryImpl implements SeckillUserRepository {

    private final SeckillUserMapper seckillUserMapper;

    public SeckillUserRepositoryImpl(SeckillUserMapper seckillUserMapper) {
        this.seckillUserMapper = seckillUserMapper;
    }

    @Override
    public SeckillUser getSeckillUserByUsername(String username) {
        return seckillUserMapper.getSeckillUserByUserName(username);
    }

    @Override
    public SeckillUser insert(SeckillUser seckillUser) {
        seckillUser.setPassword(CryptoUtil.encrypt(seckillUser.getUsername(), seckillUser.getPassword()));
        seckillUserMapper.insert(seckillUser);
        return seckillUser;
    }

}
