package com.springboot.myenglish.controller.admin;

import com.springboot.myenglish.pojo.User;
import com.springboot.myenglish.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
public class AdminLoginController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/admin")
    public String AdminLogin(User user, Model model, HttpSession session){
        User usr = userService.AdminLogin(user);
        if (usr!=null){

            session.setAttribute("loginUser",usr);
            System.out.println("Quản trị viên đã đăng nhập thành công");
            return "redirect:/admin/main";
        }else {
            model.addAttribute("msg","Mật khẩu hoặc tài khoản nhập sai");
            return "admin/index";
        }
    }

    @RequestMapping("/getStringParam/{newname}")
    public String getStringParam(@PathVariable("newname") String newName, HttpSession session) {
        // Lấy người dùng từ session và sửa đổi tên
        User loginUser = (User) session.getAttribute("loginUser");
        loginUser.setUserName(newName);
        // Sửa đổi tên trong cơ sở dữ liệu
        userService.updateUser(loginUser);
        return "redirect:/admin/main";
    }

    /**
     *  đăng xuất
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "admin/index";
    }
}
