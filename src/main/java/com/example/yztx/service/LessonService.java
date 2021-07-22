package com.example.yztx.service;

import com.example.yztx.constant.StatusType;
import com.example.yztx.domain.Lesson;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.repository.LessonRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LessonService {
    @Resource
    private LessonRepository lessonRepository;

    //存储与更新
    public SimpleMsg save(Lesson lesson) {
        try {
            lessonRepository.save(lesson);
            return new SimpleMsg(StatusType.SUCCESSFUL, getCount());
        } catch (Exception e) {
            return new SimpleMsg(StatusType.ERROR_MYSQL, "上传失败，数据库错误");
        }
    }

    //获取下一个的id
    public Long getCount() {
        Long maxId = lessonRepository.getMaxId();
        if (maxId == null) return 1L;
        return maxId;
    }

    //通过id获取Lesson
    public Lesson getById(Long id) {
        if (lessonRepository.findById(id).isPresent())
            return lessonRepository.findById(id).get();
        return null;
    }

}
