package com.wj.myapp.resp;

import com.google.gson.Gson;
import com.wj.myapp.LoginActivity;

public class BaseResponse<T> {


    private int code;

    private String msg;

    private T data;


    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }
}