package com.springboot.myenglish.controller;

import com.springboot.myenglish.pojo.User;
import com.springboot.myenglish.service.Impl.UserServiceImpl;
import org.sonatype.sisu.siesta.common.error.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/auth")
public class LoginController {


    @Autowired
    private UserServiceImpl userService;

    /**Người dùng bình thường đăng nhập
     */
    @RequestMapping("/login")
    public ResponseEntity<?> login(User user){
        User usr = userService.loginByEmailAndPasswordAndActiveStatus(user);
        if (usr == null){
            throw new BadRequestException("Mật khẩu hoặc tài khoản không chính xác");
        }else {
            return ResponseEntity.ok(usr);
        }
    }

}
