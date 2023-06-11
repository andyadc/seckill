package com.andyadc.seckill.domain.exception;

import com.andyadc.seckill.domain.code.HttpCode;

public class SeckillException extends RuntimeException {

    private static final long serialVersionUID = -8025850198256006923L;

    private String code;

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(HttpCode errorCode) {
        this(errorCode.getCode() + "", errorCode.getMesaage());
    }

    public SeckillException(String code, String messgae) {
        super(messgae);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
