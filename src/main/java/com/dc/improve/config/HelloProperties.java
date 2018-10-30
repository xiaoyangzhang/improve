package com.dc.improve.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * @program: improve
 * @description:
 * @author: zhangxiaoyang
 * @date: 2018/9/4 下午3:07
 **/
//@ConfigurationProperties(prefix = "test")
@Configuration
public class HelloProperties implements Serializable {
    private static final long serialVersionUID = -5011328293094750362L;

    private String msg = "default";

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
