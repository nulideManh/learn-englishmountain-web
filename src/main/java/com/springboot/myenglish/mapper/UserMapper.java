package com.springboot.myenglish.mapper;

import com.springboot.myenglish.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {


    /**
     * người dùng đã đăng ký
     * với người dùng đã đăng nhập
     */
    int addUser(User user);
    User queryUserByActiveCode(String activeCode);

    User loginByEmailAndPasswordAndActiveStatus(User user);
    User AdminLogin(User user);
    /**
     * Admin User
     */

    int deleteUser(Integer userId);
    int updateUser(User user);

    List<User> queryAllUser();
    User queryUserById(int userId);

    User queryUserByEmail(String email);
}

