package com.yshare.baselib.mvpbase.baselmpl;

/**
 * Created by Administrator on 2018/3/16.
 *
 * 请求结果基础bean,仅用于判断操作是否成功
 */

public class BaseBean<T> {

    private String code;
    private String message;

    private T data;

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
}
