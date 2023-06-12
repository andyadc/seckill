package com.andyadc.seckill.infrastructure.cache;

import com.andyadc.seckill.domain.dto.SigninUserDTO;
import com.andyadc.seckill.infrastructure.utils.JsonUtil;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalListeners;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class CacheManager {

    private static final Logger logger = LoggerFactory.getLogger(CacheManager.class);

    private static final RemovalListener<String, Object> listener = (notification) ->
            logger.info("Removed sign in user cache key: {}", notification.getKey()
            );

    private static final Cache<String, String> signinUserCache = CacheBuilder.newBuilder()
            .expireAfterWrite(61L, TimeUnit.SECONDS)
            .removalListener(RemovalListeners.asynchronous(listener, Executors.newSingleThreadExecutor()))
            .build();

    public void putSigninUserCache(String key, SigninUserDTO dto) {
        signinUserCache.put(key, JsonUtil.toJsonString(dto));
    }

    public SigninUserDTO getSigninUserCache(String key) {
        String value = signinUserCache.getIfPresent(key);
        if (!StringUtils.hasLength(value)) {
            return null;
        }
        return JsonUtil.json2Object(value, SigninUserDTO.class);
    }
}
