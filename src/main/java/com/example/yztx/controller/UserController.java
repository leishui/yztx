package com.example.yztx.controller;

import com.example.yztx.domain.User;
import com.example.yztx.repository.UserRepository;
import com.example.yztx.service.UserService;
import org.hibernate.annotations.Source;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    final UserRepository userRepository;

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "/user/sign_in")
    String sign_in(@RequestParam(value = "account") String account,
                   @RequestParam(value = "password") String password,
                   @RequestParam(value = "phone") int phone,
                   @RequestParam(value = "code") int code) {
        if (code == 1111) {
            User user = new User();
            user.account = account;
            user.password = password;
            user.phone = phone;
            user.avatar_url = "1";
            user.identity = 1;
            user.user_name = "用户" + account;
            if (userService.save(user)) {
                return "1";
            } else
                return "0";
        }
        return "0";
    }

}
