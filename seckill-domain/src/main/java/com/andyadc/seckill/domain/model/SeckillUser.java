package com.andyadc.seckill.domain.model;

import java.io.Serializable;

public class SeckillUser implements Serializable {

    private static final long serialVersionUID = 5767141629522142951L;

    private Long id;
    private String username;
    private String password;
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
