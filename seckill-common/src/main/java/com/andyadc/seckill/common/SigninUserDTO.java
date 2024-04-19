package com.andyadc.seckill.common;

import java.io.Serializable;

public class SigninUserDTO implements Serializable {

    private static final long serialVersionUID = -6016738966720527220L;

    private Long userId;
    private String token;
    private long timestamp;

    public SigninUserDTO() {
    }

    public SigninUserDTO(Long userId, String token) {
        this.userId = userId;
        this.token = token;
        this.timestamp = System.currentTimeMillis();
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "SigninUserDTO{" +
                "userId=" + userId +
                ", token=" + token +
                ", timestamp=" + timestamp +
                '}';
    }
}
