package com.dc.improve.service;

import org.springframework.stereotype.Service;

/**
 * @program: improve
 * @description:
 * @author: zhangxiaoyang
 * @date: 2018/9/4 下午3:09
 **/

//@Service("helloService")
public class HelloService {
    private String msg = "service";//如果自动配置没有读入成功，那么为默认值

    public String say() {
        return "hello " + msg;
    }//为我们服务的方法

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
