package com.springboot.myenglish.controller;

import com.springboot.myenglish.entity.UserEntity;
import com.springboot.myenglish.service.Impl.UserServiceImpl;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {


    @Autowired
    private UserServiceImpl userService;

    /**đăng nhập người dùng bình thường
     *Đăng nhập thành công, thêm session
     */
    @RequestMapping("/login")
    public String login(UserEntity user, Model model, HttpSession session){
        UserEntity usr = userService.loginByEmailAndPasswordAndActiveStatus(user);
        if (usr!=null){
            //设置session
            session.setAttribute("loginUser",usr);

            System.out.println("Đã đăng nhập thành công");
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","Mật khẩu hoặc tài khoản nhập sai");
            return "index";
        }
    }

    @RequestMapping("/admin")
    public String AdminLogin(UserEntity user, Model model,HttpSession session){
        UserEntity usr = userService.AdminLogin(user);
        if (usr!=null){

            session.setAttribute("loginUser",user);
            System.out.println("Quản trị viên đã đăng nhập thành công");
            return "redirect:/admin/main";
        }else {
            model.addAttribute("msg","Mật khẩu hoặc tài khoản nhập sai");
            return "admin/index";

        }
    }
    /**
     * đăng xuất
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "index";
    }

}
