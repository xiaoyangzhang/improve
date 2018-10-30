package com.dc.improve.model.entity;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * @program: improve
 * @description:
 * @author: zhangxiaoyang
 * @date: 2018/8/14 下午12:15
 **/
@ApiModel(value = "User",description = "用户")
public class User implements Serializable {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
