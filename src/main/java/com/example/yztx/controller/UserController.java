package com.example.yztx.controller;

import com.example.yztx.constant.DefaultValues;
import com.example.yztx.constant.StatusType;
import com.example.yztx.constant.UserIdentity;
import com.example.yztx.domain.User;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.service.UserService;
import com.example.yztx.utils.RedisUtils;
import com.example.yztx.utils.Utils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private RedisUtils redisUtils;


    @GetMapping("/user/get_all")
    SimpleMsg getAll(){
        return new SimpleMsg(StatusType.SUCCESSFUL,"获取成功",userService.getAll());
    }

    /**
     * showdoc
     * @catalog 与子同行/用户
     * @title 注册
     * @description 用户注册
     * @method post
     * @url user/sign_in
     * @param password 必选 String 密码
     * @param phone    必选 Long 手机号
     * @param code     必选 int 验证码
     * @return {"status":200,"msg":"注册成功"}
     * @return_param status int 成功与否
     * @return_param msg String 成功则返回注册成功，失败则返回失败原因
     */
    @PostMapping(path = "/user/sign_in")
    SimpleMsg sign_in(
                      @RequestParam(value = "password") String password,
                      @RequestParam(value = "phone") long phone,
                      @RequestParam(value = "code") int code,
                      @RequestParam("identity") int identity,
                      @RequestParam("date") long date) {
        if (redisUtils == null) redisUtils = new RedisUtils();
        String s = redisUtils.get(String.valueOf(phone));
        if (s == null) return new SimpleMsg(StatusType.FAILED, "注册失败：验证码失效");
        if (code == Integer.parseInt(s)) {
            User user = new User();
            user.account = String.valueOf(phone);
            user.password = password;
            user.phone = phone;
            user.des = "";
            user.avatar_url = DefaultValues.DEFAULT_AVATAR;
            user.identity = identity;
            user.date = date;
            user.user_name = "用户" + phone;
            if (userService.save(user)) {
                return new SimpleMsg(StatusType.SUCCESSFUL, "注册成功",userService.getByPhone(phone));
            } else
                return new SimpleMsg(StatusType.ERROR_MYSQL, "注册失败");
        }
        return new SimpleMsg(StatusType.FAILED, "注册失败：验证码错误");
    }

    /**
     * showdoc
     * @catalog 与子同行/用户
     * @title 账号登录
     * @description 账号登录
     * @method post
     * @url user/login_by_account
     * @param account 必选 String 账号
     * @param password 必选 String 密码
     * @return {"status":200,"msg":{"user_id":1,"user_name":"用户999","account":"999","password":"content","phone":10086,"identity":1,"avatar_url":"1","email":null,"wallet":0,"subscription_count":0,"fan_count":0,"collection_count":0}}
     * @return_param status int 成功与否
     * @return_param msg User/String 成功则返回用户信息，失败则返回失败原因
     */
    @PostMapping(path = "/user/login_by_account")
    SimpleMsg loginByAcc(@RequestParam(value = "account") String account,
                         @RequestParam(value = "password") String password) {
        return (userService.getLoginAccount(account, password) != null) ?
                new SimpleMsg(StatusType.SUCCESSFUL, userService.getByAccount(account)) :
                new SimpleMsg(StatusType.FAILED, "登录失败，账号或密码错误");
    }

    /**
     * showdoc
     * @catalog 与子同行/用户
     * @title 手机号登录
     * @description 手机号登录
     * @method post
     * @url user/login_by_phone
     * @param phone 必选 Long 手机号
     * @param password 必选 String 密码
     * @return {"status":200,"msg":{"user_id":1,"user_name":"用户999","account":"999","password":"content","phone":10086,"identity":1,"avatar_url":"1","email":null,"wallet":0,"subscription_count":0,"fan_count":0,"collection_count":0}}
     * @return_param status int 成功与否
     * @return_param msg User/String 成功则返回用户信息，失败则返回失败原因
     */
    @PostMapping(path = "/user/login_by_phone")
    SimpleMsg loginByAcc(@RequestParam(value = "phone") long phone,
                         @RequestParam(value = "password") String password) {
        return (userService.getLoginPhone(phone, password) != null) ?
                new SimpleMsg(StatusType.SUCCESSFUL, userService.getByPhone(phone)) :
                new SimpleMsg(StatusType.FAILED, "登录失败，手机号或密码错误");
    }

    /**
     * showdoc
     * @catalog 与子同行/用户
     * @title 获取验证码
     * @description 通过手机号获取验证码
     * @method get
     * @url /user/get_code
     * @param phone 必选 Long 手机号
     * @return {"status":200,"msg":"259311"}
     * @return_param status int 成功与否
     * @return_param msg String 成功则返回验证码，失败则返回失败原因
     * @remark 验证码有效时间60秒
     */
    @GetMapping(path = "/user/get_code")
    SimpleMsg getCode(@RequestParam(value = "phone") long phone) {
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
     * showdoc
     * @catalog 与子同行/用户
     * @title 获取用户信息
     * @description 通过用户id获取用户信息
     * @method get
     * @url /user/get_info
     * @param id 必选 Long 用户id
     * @return {"status":200,"msg":{"user_id":1,"user_name":"用户999","account":"999","password":"content","phone":10086,"identity":1,"avatar_url":"1","email":null,"wallet":0,"subscription_count":0,"fan_count":0,"collection_count":0}}
     * @return_param status int 成功与否
     * @return_param msg User/String 成功则返回用户信息，失败则返回失败原因
     */
    @GetMapping(path = "/user/get_info")
    SimpleMsg getInfo(@RequestParam(value = "id") Long id){
        if(userService.getUserById(id).isPresent())
            return new SimpleMsg(StatusType.SUCCESSFUL,"登录成功",userService.getUserById(id).get());
        return new SimpleMsg(StatusType.FAILED,"用户不存在");
    }


}
