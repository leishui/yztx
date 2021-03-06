package com.example.yztx.service;

import com.example.yztx.constant.StatusType;
import com.example.yztx.domain.Stvd;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.repository.StvdRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StvdService {
    @Resource
    private StvdRepository stvdRepository;

    //存储与更新
    public SimpleMsg save(Stvd stvd) {
        try {
            stvdRepository.save(stvd);
            return new SimpleMsg(StatusType.SUCCESSFUL, "存储成功");
        } catch (Exception e) {
            return new SimpleMsg(StatusType.ERROR_MYSQL, "上传失败，数据库错误");
        }
    }

    //通过id获取Stvd
    public Stvd getById(long id) {
         if (stvdRepository.findById(id).isPresent())
            return stvdRepository.findById(id).get();
        return null;
    }
}
