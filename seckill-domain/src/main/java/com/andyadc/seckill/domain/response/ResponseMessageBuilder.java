package com.andyadc.seckill.domain.response;

import com.andyadc.seckill.domain.code.ResponseCode;

public final class ResponseMessageBuilder {

    public static <T> ResponseMessage<T> success(T body) {
        return build(ResponseCode.SUCCESS.code(), ResponseCode.SUCCESS.mesaage(), body);
    }

    public static <T> ResponseMessage<T> build(String code, String message) {
        return build(code, message, null);
    }

    public static <T> ResponseMessage<T> build(String code, String message, T body) {
        return new ResponseMessage<T>(code, message, body);
    }

    public static <T> ResponseMessage<T> build(String code) {
        return new ResponseMessage<T>(code);
    }
}
