package com.springboot.myenglish.controller;

import com.springboot.myenglish.payload.response.MessageResponse;
import com.springboot.myenglish.pojo.User;
import com.springboot.myenglish.service.Impl.SendEmailImpl;
import com.springboot.myenglish.service.Impl.UserServiceImpl;
import com.springboot.myenglish.util.IDUtils;
import org.springframework.http.ResponseEntity;
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
    @RequestMapping("/register")
    public ResponseEntity<?> register(User user){
        //System.out.println(userService.queryUserByEmail(user.getEmail()));
        if (userService.queryUserByEmail(user.getEmail()) == null) {
            return ResponseEntity.badRequest().body(new MessageResponse("Email đã tồn tại"));
        }
        user.setActiveStatus(0);
        String activeCode = IDUtils.getUUID();
        user.setActiveCode(activeCode);
        userService.addUser(user);
        System.out.println("Thêm thành công");
        String email = user.getEmail();
        String subject = "Email kích hoạt từ Z English";
        String context = "<a href='http://localhost:8080/user/checkCode?activeCode=" + activeCode + "'>Bấm để kích hoạt:" + activeCode + "</a>";
        sendEmail.SendEmail(email,subject,context);
        return ResponseEntity.ok(user);
    }

    @RequestMapping("/user/checkCode")
    public ResponseEntity<?> active(String activeCode){
        User user = userService.queryUserByActiveCode(activeCode);
        if (user != null)
        {
            user.setActiveStatus(1);
            user.setActiveCode(" ");
            userService.updateUser(user);
        }
        return ResponseEntity.ok(user);
    }

}
