package com.example.yztx.controller;

import com.example.yztx.constant.StatusType;
import com.example.yztx.domain.User;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.service.UserService;
import com.example.yztx.utils.RedisUtils;
import com.example.yztx.utils.Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService;
    private RedisUtils redisUtils;


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

    /**
     * 获取验证码
     * @param phone 手机号
     */
    @GetMapping(path = "/user/get_code")
    SimpleMsg get_code(@RequestParam(value = "phone") int phone){
        SimpleMsg msg = new SimpleMsg();
        if (redisUtils == null) redisUtils = new RedisUtils();
        String code = Utils.generateVerificationCode();
        try {
            redisUtils.add(String.valueOf(phone),code);
        }catch (Exception e){
            msg.setStatus(StatusType.ERROR_REDIS);
            msg.setMsg("redis数据插入失败");
            return msg;
        }
        msg.setStatus(StatusType.SUCCESSFUL);
        msg.setMsg("验证码获取成功");
        return msg;
    }
}
