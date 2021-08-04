package com.example.yztx.service;

import com.example.yztx.constant.StatusType;
import com.example.yztx.domain.Comment;
import com.example.yztx.domain.Liked;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.repository.LikedRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LikedService {
    @Resource
    LikedRepository likedRepository;
    /**
     * 发起点赞
     *
     * @return SimpleMsg
     */
    public SimpleMsg saveLiked(Liked liked){
        try {
            likedRepository.save(liked);
            return new SimpleMsg(StatusType.SUCCESSFUL, "存储成功");
        } catch (Exception e) {
            return new SimpleMsg(StatusType.ERROR_MYSQL, "上传失败，数据库错误");
        }
    }
}
