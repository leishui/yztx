package com.example.yztx.service;

import com.example.yztx.constant.StatusType;
import com.example.yztx.domain.Collection;
import com.example.yztx.domain.Follow;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.repository.FollowRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FollowService {
    @Resource
    FollowRepository followRepository;

    /**
     * 发起关注
     *
     * @return SimpleMsg
     */
    public SimpleMsg saveFollow(Follow follow) {
        try {
            followRepository.save(follow);
            return new SimpleMsg(StatusType.SUCCESSFUL, "存储成功");
        } catch (Exception e) {
            return new SimpleMsg(StatusType.ERROR_MYSQL, "上传失败，数据库错误");
        }
    }
}


