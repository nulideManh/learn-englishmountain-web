package com.springboot.myenglish.controller;

import com.springboot.myenglish.entity.UserEntity;
import com.springboot.myenglish.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserServiceImpl userService;

    // Người dùng có thể tự thay đổi tên
    // Nhận chuỗi từ giao diện người dùng
    @RequestMapping("/getStringParam/{newname}")
    public String getStringParam(@PathVariable("newname") String newName, HttpSession session) {
        //Đưa người dùng khỏi phiên và sửa đổi tên của phiên
        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");
        loginUser.setUserName(newName);
        //Thay đổi tên trong cơ sở dữ liệu
        userService.updateUser(loginUser);


        return "redirect:/main.html";
    }

    //Truy cập trang thông tin sửa đổi người dùng
    @RequestMapping("/toUser")
    public String toUser(HttpSession session, Model model) {
        //Đưa người dùng từ session và sửa đổi tên của session
        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");

        model.addAttribute("loginUser", loginUser);


        return "user/user";
    }

    //Thông tin sửa đổi người dùng
    @RequestMapping("/userUpdate/{userId}")
    public String userUpdate(@PathVariable("userId") Integer userId, UserEntity user, HttpSession session) {
        UserEntity user1 = userService.queryUserById(userId);
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        user1.setUserName(user.getUserName());
        //Sửa đổi thông tin
        userService.updateUser(user1);

        //đặt phiên
        session.setAttribute("loginUser", user);

        return "redirect:/main.html";
    }

}
