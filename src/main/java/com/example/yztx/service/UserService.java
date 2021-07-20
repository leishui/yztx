package com.example.yztx.service;

import com.example.yztx.domain.User;
import com.example.yztx.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public Boolean save(User user){
        try {
            userRepository.save(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Optional<User> getUserById(Long userId){
        return userRepository.findById(userId);
    }

    //账号登录
    public User getLoginAccount(String account, String password){
        return userRepository.findUserByAccountAndPassword(account,password);
    }
    //手机号登录
    public User getLoginPhone(int phone, String password){
        return userRepository.findUserByPhoneAndPassword(phone,password);
    }
    //判断账号是否存在
    public Boolean isAccountSaved(String account){
        return userRepository.existsUserByAccount(account);
    }
    //通过账号获取用户信息
    public User getByAccount(String account){
        return userRepository.findUserByAccount(account);
    }
    //通过手机号获取用户信息
    public User getByPhone(int phone){
        return userRepository.findUserByPhone(phone);
    }

    public void update(User user){
        userRepository.save(user);
    }
}
