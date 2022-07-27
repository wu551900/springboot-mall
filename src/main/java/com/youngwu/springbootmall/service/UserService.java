package com.youngwu.springbootmall.service;

import com.youngwu.springbootmall.dto.user.RegisterUserRequest;
import com.youngwu.springbootmall.dto.user.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse register(RegisterUserRequest request);
}
