package com.wj.myapp.resp;

public class LoginResp {

    private String token;

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "LoginResp{" +
                "token='" + token + '\'' +
                '}';
    }
}