package com.springboot.myenglish.mapper;

import com.springboot.myenglish.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserMapper {


    /**
     * người dùng đã đăng ký
     * với người dùng đã đăng nhập
     */
    //Thêm người dùng - đăng ký người dùng
    int addUser(UserEntity user);
    //Truy vấn người dùng bằng mã kích hoạt
    UserEntity queryUserByActiveCode(String activeCode);

    //Đăng nhập theo mật khẩu tài khoản và activeCode (1)
    UserEntity loginByEmailAndPasswordAndActiveStatus(UserEntity user);
    //Đăng nhập theo mật khẩu tài khoản và vai trò = 1
    UserEntity AdminLogin(UserEntity user);
    /**
     * người dùng quản trị
     *
     */

    //xóa người dùng
    int deleteUser(Integer userId);
    //sửa đổi người dùng
    int updateUser(UserEntity user);


    //Truy vấn tất cả thông tin người dùng
    List<UserEntity> queryAllUser();
    //truy vấn người dùng theo id
    UserEntity queryUserById(int userId);

}
