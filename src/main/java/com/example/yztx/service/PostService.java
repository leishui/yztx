package com.example.yztx.service;

import com.example.yztx.constant.StatusType;
import com.example.yztx.domain.Lesson;
import com.example.yztx.domain.Post;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.repository.LessonRepository;
import com.example.yztx.repository.PostRepository;
import com.example.yztx.repository.UserRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class PostService {
    @Resource
    private PostRepository postRepository;
    @Resource
    private UserRepository userRepository;

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

    public SimpleMsg getByPage(int page, int size) {
        Page<Post> posts = postRepository.findAll(PageRequest.of(page, size, Sort.Direction.DESC, "postId"));
        for (Post post : posts) {
            String resources = post.post_resources;
            if (resources != null)
                post.postResourcesList = new Gson().fromJson(StringEscapeUtils.unescapeJava(resources), new TypeToken<ArrayList<String>>(){}.getType());
            post.user = userRepository.findUserByUserId(post.uploader_id);
        }
        return new SimpleMsg(StatusType.SUCCESSFUL, posts);
    }
}



