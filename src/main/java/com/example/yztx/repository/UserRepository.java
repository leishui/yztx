package com.example.yztx.repository;

import com.example.yztx.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    //账号登录使用
    User findUserByAccountAndPassword(String account,String password);
    //手机号登录使用
    User findUserByPhoneAndPassword(int phone,String password);
    //查询账号是否已存在
    Boolean existsUserByAccount(String account);
    //查询手机号是否已被绑定
    User findUserByPhone(int phone);
    User findUserByAccount(String account);
}
