package com.springboot.myenglish.service;


import com.springboot.myenglish.entity.UserEntity;

import java.util.List;

public interface UserService {
    //View all information
    UserEntity queryUserById(int userId);

    //Truy vấn người dùng bằng mã kích hoạt
    UserEntity queryUserByActiveCode(String activeCode);
    //Đăng nhập theo mật khẩu email và mã trạng thái
    UserEntity loginByEmailAndPasswordAndActiveStatus(UserEntity user);
    //Theo mật khẩu hộp thư và đăng nhập Role=1
    UserEntity AdminLogin(UserEntity user);

    //thêm người dùng
    int addUser(UserEntity user);
    //xóa người dùng
    int deleteUser(Integer userId);
    // sửa đổi người dùng
    int updateUser(UserEntity user);
    //truy vấn người dùng
    List<UserEntity> queryAllUser();


}
