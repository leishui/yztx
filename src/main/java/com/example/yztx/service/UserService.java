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

    public User getLoginAccount(String account, String password){
        return userRepository.findUserByAccountAndPassword(account,password);
    }

    public User getLoginPhone(int phone, String password){
        return userRepository.findUserByPhoneAndPassword(phone,password);
    }

    public Boolean isSaved(String account){
        return userRepository.existsUserByAccount(account);
    }

    public User getByAccount(String account){
        return userRepository.findUserByAccount(account);
    }

    public User getByPhone(int phone){
        return userRepository.findUserByPhone(phone);
    }

    public void update(User user){
        userRepository.save(user);
    }
}
