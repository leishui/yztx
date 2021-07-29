package com.example.yztx.service;

import com.example.yztx.constant.StatusType;
import com.example.yztx.domain.Lesson;
import com.example.yztx.domain.Post;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.repository.LessonRepository;
import com.example.yztx.repository.PostRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PostService {
    @Resource
    private PostRepository postRepository;

    //存储与更新
    public SimpleMsg save(Post post) {
        try {
            postRepository.save(post);
            return new SimpleMsg(StatusType.SUCCESSFUL, "存储成功");
        } catch (Exception e) {
            return new SimpleMsg(StatusType.ERROR_MYSQL, "上传失败，数据库错误");
        }
    }

    //通过id获取Post
    public Post getById(Long id) {
        if (postRepository.findById(id).isPresent())
            return postRepository.findById(id).get();
        return null;
    }
}



