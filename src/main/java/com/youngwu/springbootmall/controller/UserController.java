package com.youngwu.springbootmall.controller;

import com.youngwu.springbootmall.dto.user.RegisterUserRequest;
import com.youngwu.springbootmall.dto.user.RegisterUserResponse;
import com.youngwu.springbootmall.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@Api(value = "帳號功能", tags = {"帳號功能"})
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("用戶註冊")
    @PostMapping("/user/register")
    public RegisterUserResponse register(@RequestBody @Valid RegisterUserRequest request) {
        return userService.register(request);
    }
}
