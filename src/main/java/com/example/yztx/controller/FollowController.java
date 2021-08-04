package com.example.yztx.controller;

import com.example.yztx.domain.Collection;
import com.example.yztx.domain.Follow;
import com.example.yztx.domain.User;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.repository.CollectionRepository;
import com.example.yztx.service.FollowService;
import com.example.yztx.utils.Utils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;

@RestController
public class FollowController {
    @Resource
    FollowService followService;
    /**
     * showdoc
     *
     * @param to_id    必选 Long    关注对象id
     * @param from_id  必选 long  发起关注id
     * @return {"status":200,"msg":{"content":[{"id":1,"comment_id":1,"comment_content":"1","comment_time":1111111,"like_count":1,"reply_count":1,"commentator_id":1,"commentator_name":"用户111","commentator_url":"1","replies":{"content":[{"id":1,"reply_id":1,"reply_content":"222","replyFather":1,"reply_time":1,"like_count":1,"replier_id":1,"replier_name":"用户111","replier_url":null}],"pageable":{"sort":{"sorted":true,"unsorted":false,"empty":false},"offset":0,"pageNumber":0,"pageSize":5,"unpaged":false,"paged":true},"totalElements":1,"totalPages":1,"last":true,"size":5,"number":0,"sort":{"sorted":true,"unsorted":false,"empty":false},"numberOfElements":1,"first":true,"empty":false}}],"pageable":{"sort":{"sorted":true,"unsorted":false,"empty":false},"offset":0,"pageNumber":0,"pageSize":5,"unpaged":false,"paged":true},"totalElements":1,"totalPages":1,"last":true,"size":5,"number":0,"sort":{"sorted":true,"unsorted":false,"empty":false},"numberOfElements":1,"first":true,"empty":false}}
     * @catalog 与子同行/关注
     * @title 发起关注
     * @description 关注
     * @method post
     * @url follow/sava_follow
     * @return_param status int 成功与否
     * @return_param msg String 成功则返回关注数据，失败则返回失败原因
     */


    @PostMapping("/follow/sava_follow")
    @ResponseBody
    public SimpleMsg saveCollection(@RequestParam("to_id") Long to_id,
                                    @RequestParam("from_id") Long from_id,
                                    @RequestParam("user_name") String user_name,
                                    @RequestParam("avatar_url") String avatar_url,
                                    @RequestParam("des")String des,
                                    @RequestParam("identity")int identity) {


        Follow follow = new Follow();
        User user = new User();
        follow.to_id=to_id;
        follow.from_id=from_id;
        user.user_name=user_name;
        user.avatar_url=avatar_url;
        user.des=des;

        return followService.saveFollow(follow);
    }

}


