package com.springboot.myenglish.entity;

import lombok.Data;

@Data
public class UserEntity {
    private Integer userId;
    private String userName;
    private String password;
    private String email;
    private String activeCode;
    private int activeStatus;
    private int role;
}
