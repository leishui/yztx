package com.example.yztx.service;

import com.example.yztx.constant.StatusType;

import com.example.yztx.domain.Sign;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.repository.SignRepository;
import com.example.yztx.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class SignService {
    @Resource
    SignRepository signRepository;
    @Resource
    UserRepository userRepository;
    /**
     * 发起签到
     *
     * @return SimpleMsg
     */
    public SimpleMsg saveSign(Sign sign){
        try {
            signRepository.save(sign);
            return new SimpleMsg(StatusType.SUCCESSFUL, "存储成功");
        } catch (Exception e) {
            return new SimpleMsg(StatusType.ERROR_MYSQL, "上传失败，数据库错误");
        }
    }


}
