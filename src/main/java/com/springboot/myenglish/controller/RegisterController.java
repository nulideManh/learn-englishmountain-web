package com.springboot.myenglish.controller;

import com.springboot.myenglish.entity.UserEntity;
import com.springboot.myenglish.service.Impl.SendEmailImpl;
import com.springboot.myenglish.service.Impl.UserServiceImpl;
import com.springboot.myenglish.util.IDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class RegisterController {
    @Resource
    private UserServiceImpl userService;

    @Resource
    private SendEmailImpl sendEmail;
    //đăng ký
    @RequestMapping("/register")
    public String register(UserEntity user, Model model){
        //Trạng thái hoạt động là 0
        user.setActiveStatus(0);
        //nhận được một UUID
        String activeCode = IDUtils.getUUID();
        user.setActiveCode(activeCode);
        //thêm vào cơ sở dữ liệu
        userService.addUser(user);
        System.out.println("thêm thành công");
        //Gửi email để kích hoạt
        String email = user.getEmail();
        String subject = "Email kích hoạt từ Moutain English";
        String context = "<a href='http://localhost:8080/user/checkCode?activeCode=" + activeCode + "'>Bấm để kích hoạt:" + activeCode + "</a>";
        sendEmail.SendEmail(email,subject,context);
        //Quay lại trang chính để nhắc người dùng
        model.addAttribute("msg","Sau khi đăng ký thành công, vui lòng vào email để kích hoạt");
        return "index";
    }

    //Xác minh mã kích hoạt Đăng nhập
    @RequestMapping("/user/checkCode")
    public String active(String activeCode,Model model){
        //Kiểm tra mã kích hoạt này
        UserEntity user = userService.queryUserByActiveCode(activeCode);
        if (user != null)
        {   model.addAttribute("msg","Chúc mừng bạn đã kích hoạt thành công，Bây giờ bạn có thể đăng nhập");
            //Kích hoạt cho người dùng này
            user.setActiveStatus(1);
            //Xóa mã kích hoạt
            user.setActiveCode(" ");
            userService.updateUser(user);
        }
        return "index";
    }

}

