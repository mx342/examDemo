package com.tianyou.exam.controller;

public class ApiResponse<T> {

    private Integer code;

    private String msg;

    private T data;


    public static ApiResponse OK() {
        ApiResponse response = new ApiResponse();
        response.setCode(0);
        response.setMsg("");
        return response;
    }


    public static ApiResponse FAIL(String msg) {
        ApiResponse response = new ApiResponse();
        response.setCode(1);
        response.setMsg(msg);
        return response;
    }

    public ApiResponse data(T data) {
        this.data = data;
        return this;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
