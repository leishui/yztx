package com.example.yztx.controller;

import com.example.yztx.domain.Test;
import com.example.yztx.repository.TestRepository;
import com.example.yztx.utils.RedisUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {
    final TestRepository testRepository;

    public TestController(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Resource
    RedisUtils redisUtils;

    @GetMapping(path = "/test")
    public Iterable<Test> test(@RequestParam(value = "test",defaultValue = "1") String t){
        return testRepository.findAll();
    }

    @GetMapping(path = "/test1")
    public void test1(@RequestParam(value = "test",defaultValue = "1") String t){
        redisUtils.add("test",t);
    }
}
