package com.andyadc.seckill.vo;

/**
 * @author andy.an
 * @since 2018/8/27
 */
public class R<T> {

    private String code;
    private String message;
    private T data;

    public R() {
    }

    public R(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public R(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "R{" +
                "code=" + code +
                ", message=" + message +
                ", data=" + data +
                "}";
    }
}
