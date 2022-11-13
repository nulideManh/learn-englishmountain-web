package com.springboot.myenglish.controller.admin;

import com.springboot.myenglish.entity.UserEntity;
import com.springboot.myenglish.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UpdateUserController {
    @Autowired
    UserServiceImpl userService;

    /**
     * Xem người dùng
     */
    @RequestMapping("/admin/viewUser")
    public String viewUser(Model model) {
        List<UserEntity> user = userService.queryAllUser();
        model.addAttribute("user", user);
        return "admin/User-View";
    }


    /**
     * sửa đổi người dùng
     */
    //đi đến trang chỉnh sửa
    @RequestMapping("/admin/toUpdateUser/{userId}")
    public String toUpdateUser(@PathVariable("userId") Integer userId, Model model) {

        UserEntity user = userService.queryUserById(userId);

        model.addAttribute("user", user);
        return "admin/User-Update";
    }

    //Thực hiện các thay đổi và gửi, quay lại trang view
    @RequestMapping("/admin/updateUser/{userId}")
    public String updateUser(@PathVariable("userId") Integer userId, UserEntity user) {
        userService.updateUser(user);

        return "redirect:/admin/viewUser";
    }

    /**
     * xóa người dùng
     */

    @RequestMapping("/admin/deleteUser/{userId}")
    public String deleteUser(@PathVariable("userId") Integer userId) {

        userService.deleteUser(userId);


        return "redirect:/admin/viewUser";
    }

    /**
     * thêm người dùng
     */
//
    @RequestMapping("/admin/toAddUser")
    public String toAddUser() {
        return "admin/User-Add";
    }

    @PostMapping("/admin/addUser")
    public String addUser(UserEntity user) {
        userService.addUser(user);

        return "redirect:/admin/viewUser";
    }
}
