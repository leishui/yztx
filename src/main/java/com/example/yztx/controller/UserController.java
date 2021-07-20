package com.example.yztx.controller;

import com.example.yztx.constant.DefaultValues;
import com.example.yztx.constant.StatusType;
import com.example.yztx.constant.UserIdentity;
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


    /**
     * 注册
     *
     * @param account  账号
     * @param password 密码
     * @param phone    手机号
     * @param code     验证码
     * @return SimpleMsg
     */
    @PostMapping(path = "/user/sign_in")
    SimpleMsg sign_in(@RequestParam(value = "account") String account,
                      @RequestParam(value = "password") String password,
                      @RequestParam(value = "phone") int phone,
                      @RequestParam(value = "code") int code) {
        if (redisUtils == null) redisUtils = new RedisUtils();
        String s = redisUtils.get(String.valueOf(phone));
        if (s == null) return new SimpleMsg(StatusType.FAILED, "注册失败：验证码失效");
        if (code == Integer.parseInt(s)) {
            if (userService.isSaved(account))
                return new SimpleMsg(StatusType.FAILED, "注册失败：账号已存在");
            User user = new User();
            user.account = account;
            user.password = password;
            user.phone = phone;
            user.avatar_url = DefaultValues.DEFAULT_AVATAR;
            user.identity = UserIdentity.NORMAL;
            user.user_name = "用户" + account;
            if (userService.save(user)) {
                return new SimpleMsg(StatusType.SUCCESSFUL, "注册成功");
            } else
                return new SimpleMsg(StatusType.ERROR_MYSQL, "注册失败");
        }
        return new SimpleMsg(StatusType.FAILED, "注册失败：验证码错误");
    }

    /**
     * 账号登录
     * @param account 账号
     * @param password 密码
     * @return 是否成功
     */
    @PostMapping(path = "/user/login_by_account")
    SimpleMsg loginByAcc(@RequestParam(value = "account") String account,
                         @RequestParam(value = "password") String password) {
        return (userService.getLoginAccount(account, password) != null) ?
                new SimpleMsg(StatusType.SUCCESSFUL, userService.getByAccount(account)) :
                new SimpleMsg(StatusType.FAILED, "登录失败，账号或密码错误");
    }

    /**
     * 手机号登录
     * @param phone 手机号
     * @param password 密码
     * @return 是否成功
     */
    @PostMapping(path = "/user/login_by_phone")
    SimpleMsg loginByAcc(@RequestParam(value = "phone") int phone,
                         @RequestParam(value = "password") String password) {
        return (userService.getLoginPhone(phone, password) != null) ?
                new SimpleMsg(StatusType.SUCCESSFUL, userService.getByPhone(phone)) :
                new SimpleMsg(StatusType.FAILED, "登录失败，手机号或密码错误");
    }

    /**
     * 获取验证码
     *
     * @param phone 手机号
     * @return SimpleMsg
     */
    @GetMapping(path = "/user/get_code")
    SimpleMsg getCode(@RequestParam(value = "phone") int phone) {
        SimpleMsg msg = new SimpleMsg();
        if (userService.getByPhone(phone)!=null)
            return new SimpleMsg(StatusType.FAILED,"手机号已被使用");
        if (redisUtils == null) redisUtils = new RedisUtils();
        String code = Utils.generateVerificationCode();
        try {
            redisUtils.add(String.valueOf(phone), code);
        } catch (Exception e) {
            msg.setStatus(StatusType.ERROR_REDIS);
            msg.setMsg("redis数据插入失败");
            return msg;
        }
        msg.setStatus(StatusType.SUCCESSFUL);
        msg.setMsg(code);
        return msg;
    }

    /**
     * 获取用户信息
     * @param id 所需id
     * @return 是否存在
     */
    @GetMapping(path = "/user/get_info")
    SimpleMsg getInfo(@RequestParam(value = "id") Long id){
        if(userService.getUserById(id).isPresent())
            return new SimpleMsg(StatusType.SUCCESSFUL,userService.getUserById(id).get());
        return new SimpleMsg(StatusType.FAILED,"用户不存在");
    }
    //账号登录
    //手机号登录
    //获取用户信息
}
