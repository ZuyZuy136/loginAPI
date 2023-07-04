package com.example.loginAPI.controller;

import com.example.loginAPI.request.UserChangePassWordRequest;
import com.example.loginAPI.request.UserLoginRequest;
import com.example.loginAPI.request.UserRegistrationRequest;
import com.example.loginAPI.service.UserService;
import com.example.loginAPI.service.userServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegistrationRequest request){
        service.register(request);
        String regíterationStatus = userServiceImpl.regíterationStatus;
        return new ResponseEntity<String>(regíterationStatus, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginRequest loginRequest){
        service.login(loginRequest);
        String loginStatus = userServiceImpl.loginStatus;
        return new ResponseEntity<String>(loginStatus ,HttpStatus.OK);
    }

    @PutMapping("/changePassWord")
    public ResponseEntity<String> changePassWord(@RequestBody UserChangePassWordRequest changePassWordRequest){
        service.changePassWord(changePassWordRequest);
        String changePassWordStatus = userServiceImpl.changePassWordStatus;
        return new ResponseEntity<String>(changePassWordStatus ,HttpStatus.OK);
    }
}
