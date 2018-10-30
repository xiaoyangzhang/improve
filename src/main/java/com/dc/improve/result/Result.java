package com.dc.improve.result;

import java.io.Serializable;

/**
 * @program: improve
 * @description:
 * @author: zhangxiaoyang
 * @date: 2018/8/14 下午12:11
 **/

public class Result<T> implements Serializable {

    private static final long serialVersionUID = 5745486450771783599L;
    private String code;

    private String msg;

    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
