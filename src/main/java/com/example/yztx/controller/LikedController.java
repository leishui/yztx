package com.example.yztx.controller;

import com.example.yztx.domain.Liked;
import com.example.yztx.domain.Sign;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.service.LikedService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LikedController {

    @Resource
    LikedService likedService;
    /**
     * showdoc
     *
     * @param user_id   必选 Long 发起者id
     * @param status    必选 boolean 1代表点赞，0代表取消点赞
     * @param type      必选 int  类型（帖子/短视频/课程视频）
     * @return {"status":200,"msg":"存储成功"}
     * @catalog 与子同行/点赞
     * @title 点赞
     * @description 发起点赞
     * @method post
     * @url liked/upload
     * @return_param status int 成功与否
     * @return_param msg String 成功则返回存储成功，失败则返回失败原因
     */
    @PostMapping( "/liked/upload")
    @ResponseBody
    public SimpleMsg saveLiked(
            @RequestParam("user_id") Long user_id,
            @RequestParam("type") int type,
            @RequestParam("status") boolean status,
            @RequestParam("creat_time") Long creat_time) {

        Liked liked = new Liked();
        liked.creat_time=creat_time;
        liked.type=type;
        liked.user_id=user_id;
        liked.status=status;

        return likedService.saveLiked(liked);
    }
}
