package com.andyadc.seckill.application.service.impl;

import com.andyadc.seckill.application.service.SeckillUserService;
import com.andyadc.seckill.domain.model.SeckillUser;
import com.andyadc.seckill.domain.repository.SeckillUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeckillUserServiceImpl implements SeckillUserService {

    private static final Logger logger = LoggerFactory.getLogger(SeckillUserServiceImpl.class);

    private final SeckillUserRepository seckillUserRepository;

    @Autowired
    public SeckillUserServiceImpl(SeckillUserRepository seckillUserRepository) {
        this.seckillUserRepository = seckillUserRepository;
    }

    @Override
    public SeckillUser getSeckillUserByUsername(String username) {
        logger.info("username: {}", username);
        return seckillUserRepository.getSeckillUserByUsername(username);
    }
}
