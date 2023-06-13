package com.andyadc.seckill.interfaces.interceptor;

import com.andyadc.seckill.domain.code.ErrorCode;
import com.andyadc.seckill.domain.dto.SigninUserDTO;
import com.andyadc.seckill.domain.response.ResponseMessage;
import com.andyadc.seckill.domain.response.ResponseMessageBuilder;
import com.andyadc.seckill.infrastructure.cache.CacheManager;
import com.andyadc.seckill.infrastructure.context.AuthUserContext;
import com.andyadc.seckill.infrastructure.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

/**
 * 登录授权拦截验证
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

    private CacheManager cacheManager;

    @Value("#{'${auth.exclude.uri}'.split(',')}")
    private List<String> authExcludeUrl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String requestId = request.getHeader("requestId");
        if (!StringUtils.hasLength(requestId)) {
            requestId = UUID.randomUUID().toString().replace("-", "");
        }
        MDC.put("traceId", requestId);
        response.setHeader("requestId", requestId);

        for (String uri : authExcludeUrl) {
            if (requestURI.contains(uri)) {
                return true;
            }
        }

        String token = request.getHeader("token");
        if (StringUtils.hasLength(token)) {
            SigninUserDTO userDTO = cacheManager.getSigninUserCache(token);
            if (userDTO != null) {
                AuthUserContext.set(userDTO.getUserId());
                return true;
            }
        }

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());

        PrintWriter writer = response.getWriter();
        ResponseMessage<Object> message = ResponseMessageBuilder.build(ErrorCode.USER_NOT_LOGIN.code(), ErrorCode.USER_NOT_LOGIN.message());
        writer.write(JsonUtil.toJsonString(message));
        writer.flush();
        writer.close();

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC.clear();
        AuthUserContext.clear();
    }

    @Autowired
    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }
}
