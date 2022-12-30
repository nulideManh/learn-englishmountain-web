package com.springboot.myenglish.service.Impl;

import com.springboot.myenglish.mapper.UserMapper;
import com.springboot.myenglish.pojo.User;
import com.springboot.myenglish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public User queryUserById(int userId) {
        return  userMapper.queryUserById(userId);
    }

    @Override
    public User queryUserByActiveCode(String activeCode) {
        return userMapper.queryUserByActiveCode(activeCode);
    }

    @Override
    public User loginByEmailAndPasswordAndActiveStatus(User user) {
        return userMapper.loginByEmailAndPasswordAndActiveStatus(user);
    }

    @Override
    public User AdminLogin(User user) {
        return userMapper.AdminLogin(user);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUser(Integer userId) {
        return userMapper.deleteUser(userId);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    public User queryUserByEmail(String email) {
        return userMapper.queryUserByEmail(email);
    }
}
