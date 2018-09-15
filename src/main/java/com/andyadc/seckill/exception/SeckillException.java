package com.andyadc.seckill.exception;

/**
 * @author andy.an
 * @since 2018/9/15
 */
public class SeckillException extends RuntimeException {

    private String errorCode;
    private String errorMessage;

    public SeckillException(String message) {
        super(message);
        this.errorMessage = message;
    }

    public SeckillException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
        this.errorMessage = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
