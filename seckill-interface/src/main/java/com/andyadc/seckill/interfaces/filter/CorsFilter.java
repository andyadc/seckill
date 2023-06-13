package com.andyadc.seckill.interfaces.filter;

import com.andyadc.seckill.infrastructure.utils.IPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

@Order(1)
@WebFilter(urlPatterns = "*")
public class CorsFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(CorsFilter.class);

    private static final String HTTP_METHOD_OPTIONS = "OPTIONS";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("init");
    }

    /*
     * 跨域请求头服务端配置：
     * 1.Access-Control-Allow-Origin：设置允许跨域的配置， 响应头指定了该响应的资源是否被允许与给定的origin共享
     * 2.Access-Control-Allow-Credentials：响应头表示是否可以将对请求的响应暴露给页面（cookie）。返回true则可以，其他值均不可以。
     * 3.Access-Control-Allow-Headers:用于预检请求中，列出了将会在正式请求的 Access-Control-Request-Headers 字段中出现的首部信息。（自定义请求头）
     * 4.Access-Control-Allow-Methods：在对 预检请求的应答中明确了客户端所要访问的资源允许使用的方法或方法列表。
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        logger.info("Logging Request - {} : {} {}", request.getMethod(), request.getRequestURI(), IPUtil.getRemoteIP(request));

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, access-token");
        response.setHeader("Access-Control-Allow-Methods", "GET, PUT, DELETE, POST, OPTIONS");
        if (HTTP_METHOD_OPTIONS.equals(request.getMethod())) {
            response.setStatus(HttpStatus.ACCEPTED.value());
            response.getWriter().close();
            return;
        }

        Instant start = Instant.now();
        filterChain.doFilter(servletRequest, servletResponse);
        logger.info("Elapsed Time in {} ms", Duration.between(start, Instant.now()).toMillis());
    }

    @Override
    public void destroy() {
        logger.info("destroy");
    }
}
