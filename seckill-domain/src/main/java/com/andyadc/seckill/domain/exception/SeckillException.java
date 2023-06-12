package com.andyadc.seckill.domain.exception;

import com.andyadc.seckill.domain.code.ErrorCode;

public class SeckillException extends RuntimeException {

    private static final long serialVersionUID = 6072087408074461087L;

    private String code;

    public SeckillException(ErrorCode errorCode) {
        this(errorCode.getCode(), errorCode.getMesaage());
    }

    public SeckillException(ErrorCode errorCode, Throwable cause) {
        this(errorCode.getCode(), errorCode.getMesaage(), cause);
    }

    public SeckillException(String code, String messgae) {
        super(messgae);
        this.code = code;
    }

    public SeckillException(String code, String messgae, Throwable cause) {
        super(messgae, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
