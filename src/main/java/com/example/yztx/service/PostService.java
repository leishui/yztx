package com.example.yztx.service;

import com.example.yztx.repository.PostRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PostService {
    @Resource
    private PostRepository postRepository;


}



