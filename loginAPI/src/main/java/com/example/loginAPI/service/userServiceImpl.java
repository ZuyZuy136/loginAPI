package com.example.loginAPI.service;

import com.example.loginAPI.repository.UserRepository;


import com.example.loginAPI.User;
import com.example.loginAPI.request.UserChangePassWordRequest;
import com.example.loginAPI.request.UserLoginRequest;
import com.example.loginAPI.request.UserRegistrationRequest;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Builder
public class userServiceImpl implements UserService {
    public static String regíterationStatus;
    public static String loginStatus;
    public static String changePassWordStatus;
    @Autowired
    private UserRepository repository;

    @Override
    public Long register(UserRegistrationRequest request) {

        User checkUser = repository.findAllByEmail(request.getEmail());
        if (checkUser == null){
            regíterationStatus = "Registered successfully";
            return repository.save(User.builder()
                            .name(request.getName())
                            .email(request.getEmail())
                            .userName(request.getUserName())
                            .passWord(request.getPassWord())
                            .build())
                            .getUserId();
        }
        else {
            regíterationStatus = "Registered unsuccessfully";
            return null;
        }
    }

    @Override
    public Long login(UserLoginRequest loginRequest){
        User checkUserName = repository.findAllByUserName(loginRequest.getUserName());
        User checkPassWord = repository.findAllByPassWord(loginRequest.getPassWord());
        if (checkUserName != null & checkPassWord != null) {
            loginStatus = "Login successfully";
            return null;
        }
        else {
            loginStatus = "Login unsuccessfully";
            return null;
        }
    }

    @Override
    public Long changePassWord(UserChangePassWordRequest changePassWordRequest){
        User checkEmail = repository.findAllByEmail(changePassWordRequest.getEmail());
        User checkUserName = repository.findAllByUserName(changePassWordRequest.getUserName());
        if (checkEmail != null & checkUserName != null){
            User checkPassWord = repository.findAllByPassWord(changePassWordRequest.getOldPassWord());
            if (checkPassWord != null){
                checkPassWord.setPassWord(changePassWordRequest.getNewPassWord());
                repository.save(checkPassWord);
                changePassWordStatus = "Change passWord successfully";
                return null;
            }
            else {
                changePassWordStatus = "Change password unsuccessfully. Wrong old password";
                return null;
            }
        }
        else {
            changePassWordStatus = "Change password unsuccessfully. Wrong email or username";
            return null;
        }
    }
}