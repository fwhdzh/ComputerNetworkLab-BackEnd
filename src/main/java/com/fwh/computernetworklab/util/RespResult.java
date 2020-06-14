package com.fwh.computernetworklab.util;

/**
 * 弃用
 * <p>原作者用来封装相应请求的类</p>
 * <p>项目中出于方便大部分改为了直接返回字符串</p>
 * @param <T>
 */
public class RespResult<T> {

    private String statuscode;

    private String message;

    private T data;

    public RespResult() {
    }

    public RespResult(String statuscode, String message, T data) {
        this.statuscode = statuscode;
        this.message = message;
        this.data = data;
    }

    public String getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(String statuscode) {
        this.statuscode = statuscode;
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
}
