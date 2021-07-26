package com.example.yztx.service;

import com.example.yztx.constant.StatusType;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.repository.ResourceRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ResourceService {
    @Resource
    private ResourceRepository resourceRepository;

    //存储与更新
    public SimpleMsg save(com.example.yztx.domain.Resource resource) {
        try {
            resourceRepository.save(resource);
            return new SimpleMsg(StatusType.SUCCESSFUL, resource.toString());
        } catch (Exception e) {
            return new SimpleMsg(StatusType.ERROR_MYSQL, "上传失败，数据库错误");
        }
    }

    //获取下一个的id
    public Long getCount() {
        Long maxId = resourceRepository.getMaxId();
        if (maxId == null) return 1L;
        return maxId;
    }

    //通过id获取Lesson
    public com.example.yztx.domain.Resource getById(Long id) {
        if (resourceRepository.findById(id).isPresent())
            return resourceRepository.findById(id).get();
        return null;
    }

}
