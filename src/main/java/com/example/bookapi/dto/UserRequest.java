package com.example.bookapi.dto;

import lombok.Data;

@Data
public class UserRequest {

    private String name;
    private String surname;
    private String nickName;
    private String email;
    private String password;
}
