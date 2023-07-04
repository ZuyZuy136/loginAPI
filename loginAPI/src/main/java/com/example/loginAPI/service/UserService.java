package com.example.loginAPI.service;


import com.example.loginAPI.User;
import com.example.loginAPI.request.UserChangePassWordRequest;
import com.example.loginAPI.request.UserLoginRequest;
import com.example.loginAPI.request.UserRegistrationRequest;

public interface UserService {
    public Long register(UserRegistrationRequest request);

    public Long login(UserLoginRequest loginRequest);

    public Long changePassWord(UserChangePassWordRequest changePassWordRequest);
}
