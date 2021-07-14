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

    public void update(User user){
        userRepository.save(user);
    }
}
