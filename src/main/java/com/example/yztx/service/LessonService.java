package com.example.yztx.service;

import com.example.yztx.constant.StatusType;
import com.example.yztx.domain.Lesson;
import com.example.yztx.domain.LessonSet;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.repository.LessonRepository;
import com.example.yztx.repository.LessonSetRepository;
import com.example.yztx.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class LessonService {
    @Resource
    private LessonRepository lessonRepository;
    @Resource
    private UserRepository userRepository;
    @Resource
    private LessonSetRepository lessonSetRepository;

    //存储与更新
    public SimpleMsg save(Lesson lesson) {
        try {
            lessonRepository.save(lesson);
            return new SimpleMsg(StatusType.SUCCESSFUL, "存储成功");
        } catch (Exception e) {
            return new SimpleMsg(StatusType.ERROR_MYSQL, "上传失败，数据库错误");
        }
    }

    //通过id获取Lesson
    public Lesson getById(Long id) {
        if (lessonRepository.findById(id).isPresent())
            return lessonRepository.findById(id).get();
        return null;
    }

    public SimpleMsg getByPage(int page, int size) {
        Page<Lesson> lessons = lessonRepository.findAll(PageRequest.of(page, size, Sort.Direction.ASC, "lessonId"));
        for (Lesson lesson : lessons) {
            lesson.user = userRepository.findUserByUserId(lesson.uploader_id);
        }
        return new SimpleMsg(StatusType.SUCCESSFUL, lessons);
    }
    public SimpleMsg getSetByPage(int page,int size){
        Page<LessonSet> lessonSets = lessonSetRepository.findAll(PageRequest.of(page, size, Sort.Direction.ASC, "id"));
        for (LessonSet lessonSet : lessonSets) {
            ArrayList<Lesson> lessons = lessonRepository.findAllByLessonSetId(lessonSet.id);
            for (Lesson lesson : lessons) {
                lesson.user = userRepository.findUserByUserId(lesson.uploader_id);
            }
            lessonSet.lessons = lessons;
        }
        return new SimpleMsg(StatusType.SUCCESSFUL, lessonSets);
    }

}
