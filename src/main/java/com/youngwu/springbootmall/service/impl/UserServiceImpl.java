package com.youngwu.springbootmall.service.impl;

import com.youngwu.springbootmall.dto.user.RegisterUserRequest;
import com.youngwu.springbootmall.dto.user.RegisterUserResponse;
import com.youngwu.springbootmall.model.User;
import com.youngwu.springbootmall.repository.UserRepository;
import com.youngwu.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisterUserResponse register(RegisterUserRequest request) {

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        Date now = new Date();
        user.setCreatedDate(now);
        user.setLastModifiedDated(now);

        userRepository.save(user);

        RegisterUserResponse response = new RegisterUserResponse();
        response.setStatus("Success");

        return response;
    }
}
