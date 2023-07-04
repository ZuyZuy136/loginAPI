package com.example.loginAPI.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserChangePassWordRequest {
    String email;
    String userName;
    String oldPassWord;
    String newPassWord;
}