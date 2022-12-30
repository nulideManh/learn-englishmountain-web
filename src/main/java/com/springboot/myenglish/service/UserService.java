package com.springboot.myenglish.service;

import com.springboot.myenglish.pojo.User;

import java.util.List;

public interface UserService {
    User queryUserById(int userId);

    User queryUserByActiveCode(String activeCode);
    User loginByEmailAndPasswordAndActiveStatus(User user);
    User AdminLogin(User user);

    int addUser(User user);
    int deleteUser(Integer userId);
    int updateUser(User user);
    List<User> queryAllUser();

    User queryUserByEmail(String email);
}
