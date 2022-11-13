package com.springboot.myenglish.service.Impl;

import com.springboot.myenglish.entity.UserEntity;
import com.springboot.myenglish.mapper.UserMapper;
import com.springboot.myenglish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public UserEntity queryUserById(int userId) {
        return  userMapper.queryUserById(userId);
    }

    @Override
    public UserEntity queryUserByActiveCode(String activeCode) {
        return userMapper.queryUserByActiveCode(activeCode);
    }

    @Override
    public UserEntity loginByEmailAndPasswordAndActiveStatus(UserEntity user) {
        return userMapper.loginByEmailAndPasswordAndActiveStatus(user);
    }

    @Override
    public UserEntity AdminLogin(UserEntity user) {
        return userMapper.AdminLogin(user);
    }

    @Override
    public int addUser(UserEntity user) {
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUser(Integer userId) {
        return userMapper.deleteUser(userId);
    }

    @Override
    public int updateUser(UserEntity user) {
        return userMapper.updateUser(user);
    }

    @Override
    public List<UserEntity> queryAllUser() {
        return userMapper.queryAllUser();
    }


}

