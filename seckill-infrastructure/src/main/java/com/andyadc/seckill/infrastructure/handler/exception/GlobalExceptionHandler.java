package com.andyadc.seckill.infrastructure.handler.exception;

import com.andyadc.seckill.domain.code.HttpCode;
import com.andyadc.seckill.domain.exception.SeckillException;
import com.andyadc.seckill.domain.response.ResponseMessage;
import com.andyadc.seckill.domain.response.ResponseMessageBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(SeckillException.class)
    public ResponseMessage<String> handleSeckillException(SeckillException e) {
        logger.error("", e);
        return ResponseMessageBuilder.build(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseMessage<String> handleException(Exception e) {
        logger.error("", e);
        return ResponseMessageBuilder.build(HttpCode.SERVER_EXCEPTION.getCode(), e.getMessage());
    }
}
