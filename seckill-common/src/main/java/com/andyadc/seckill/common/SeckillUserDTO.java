package com.andyadc.seckill.common;

import java.io.Serializable;

public class SeckillUserDTO implements Serializable {

    private static final long serialVersionUID = -8449423549257638688L;

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
