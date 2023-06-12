package com.andyadc.seckill.application.service.impl;

import com.andyadc.seckill.application.service.SeckillUserService;
import com.andyadc.seckill.domain.code.ErrorCode;
import com.andyadc.seckill.domain.dto.SeckillUserDTO;
import com.andyadc.seckill.domain.dto.SigninUserDTO;
import com.andyadc.seckill.domain.exception.SeckillException;
import com.andyadc.seckill.domain.model.SeckillUser;
import com.andyadc.seckill.domain.repository.SeckillUserRepository;
import com.andyadc.seckill.infrastructure.cache.CacheManager;
import com.andyadc.seckill.infrastructure.crypto.CryptoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeckillUserServiceImpl implements SeckillUserService {

    private static final Logger logger = LoggerFactory.getLogger(SeckillUserServiceImpl.class);

    private SeckillUserRepository seckillUserRepository;
    private CacheManager cacheManager;

    /**
     * 生成随机字符串
     */
    private static String genRandomStr() {
        return Long.toHexString(Double.doubleToLongBits(Math.random()));
    }

    @Override
    public SeckillUser getSeckillUserByUsername(String username) {
        logger.info("username: {}", username);
        return seckillUserRepository.getSeckillUserByUsername(username);
    }

    @Override
    public boolean signup(SeckillUserDTO seckillUserDTO) {
        SeckillUser seckillUser = new SeckillUser();
        seckillUser.setUsername(seckillUserDTO.getUsername());
        seckillUser.setStatus(1);
        seckillUser.setPassword(seckillUserDTO.getPassword());
        seckillUserRepository.insert(seckillUser);
        return true;
    }

    @Override
    public SigninUserDTO signin(SeckillUserDTO seckillUserDTO) {
        String username = seckillUserDTO.getUsername();
        SeckillUser seckillUser = seckillUserRepository.getSeckillUserByUsername(username);
        String dbStoredHashedPassword = seckillUser.getPassword();

        boolean flag = CryptoUtil.match(username, seckillUserDTO.getPassword(), dbStoredHashedPassword);
        if (flag) {
            String token = genRandomStr();
            SigninUserDTO dto = new SigninUserDTO(seckillUser.getId(), token);
            cacheManager.putSigninUserCache(token, dto);
            return dto;
        } else {
            throw new SeckillException(ErrorCode.PASSWORD_IS_ERROR);
        }
    }

    @Autowired
    public void setSeckillUserRepository(SeckillUserRepository seckillUserRepository) {
        this.seckillUserRepository = seckillUserRepository;
    }

    @Autowired
    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }
}
