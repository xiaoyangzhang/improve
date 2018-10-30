package com.dc.improve.controller;

import com.dc.improve.model.entity.User;
import com.dc.improve.result.Result;
import com.dc.improve.service.HelloService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(description = "用户服务",tags = "UserController")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private HelloService helloService;

    @ApiOperation(value = "测试接口", notes = "测试接口")
    @RequestMapping(value = "/auto/home", method = RequestMethod.GET)
    public String home() {
        return helloService.say();
    }

    @ApiOperation(value = "添加用户", notes = "添加用户")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result addUser(
            @ApiParam(name = "user", value = "用户信息", required = true, type = "") @RequestBody User user) {
        Result<User> result = new Result<>();
        return null;
    }


}
