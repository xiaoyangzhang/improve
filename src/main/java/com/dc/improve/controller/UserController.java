package com.dc.improve.controller;

import com.dc.improve.model.entity.User;
import com.dc.improve.result.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @program: improve
 * @description:
 * @author: zhangxiaoyang
 * @date: 2018/8/14 下午12:06
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation(value = "添加用户", notes = "添加用户")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result addUser(
            @ApiParam(name = "user", value = "用户信息", required = true, type = "") @RequestBody @NotNull User user) {
        Result<User> result = new Result<>();
        return null;
    }

    @ApiOperation(value = "测试接口", notes = "测试接口")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    String home() {
        return "Hello World!";
    }

}
