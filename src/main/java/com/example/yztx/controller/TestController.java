package com.example.yztx.controller;

import com.example.yztx.domain.Test;
import com.example.yztx.repository.TestRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    final TestRepository testRepository;

    public TestController(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @GetMapping(path = "/test")
    public Iterable<Test> test(@RequestParam(value = "test",defaultValue = "1") String t){
        return testRepository.findAll();
    }
}
