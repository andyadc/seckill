package com.andyadc.seckill.exception;

import com.andyadc.seckill.vo.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author andy.an
 * @since 2018/9/15
 */
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = {Exception.class})
    public R<String> exceptionHandle(Exception e) {
        if (e instanceof SeckillException) {
            SeckillException se = (SeckillException) e;
            logger.error("errorCode={}, errorMessage={}", se.getErrorCode(), se.getErrorMessage(), e);
            return new R<>(se.getErrorCode(), se.getErrorMessage());
        } else {
            logger.error("", e);
            return new R<>("-1", "System error");
        }
    }
}
