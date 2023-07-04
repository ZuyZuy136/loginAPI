package com.example.loginAPI.request;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserRegistrationRequest {
    private String name;
    private String email;
    private String userName;
    private String passWord;

}