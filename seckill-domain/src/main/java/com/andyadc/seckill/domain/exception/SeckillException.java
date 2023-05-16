package com.andyadc.seckill.domain.exception;

import com.andyadc.seckill.domain.code.HttpCode;

public class SeckillException extends RuntimeException {

    private static final long serialVersionUID = -8025850198256006923L;

    private Integer code;

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(HttpCode errorCode) {
        this(errorCode.getCode(), errorCode.getMesaage());
    }

    public SeckillException(Integer code, String messgae) {
        super(messgae);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
