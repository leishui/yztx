package com.example.yztx.service;

import com.example.yztx.constant.StatusType;
import com.example.yztx.domain.Collection;
import com.example.yztx.domain.Comment;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.repository.CollectionRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CollectionService {
    @Resource
    CollectionRepository collectionRepository;

    /**
     * 发起收藏
     *
     * @return SimpleMsg
     */
    public SimpleMsg saveCollection(Collection collection) {
        try {
            collectionRepository.save(collection);
            return new SimpleMsg(StatusType.SUCCESSFUL, "存储成功");
        } catch (Exception e) {
            return new SimpleMsg(StatusType.ERROR_MYSQL, "上传失败，数据库错误");
        }
    }
}
