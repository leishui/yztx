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
     * @return {"status":200,"msg":"存储成功","content":null}
     * @catalog 与子同行/关注
     * @title 发起关注
     * @description 关注
     * @method post
     * @url follow/save_follow
     * @return_param status int 成功与否
     * @return_param msg String 成功则返回存储成功，失败则返回失败原因
     */


    @PostMapping("/follow/save_follow")
    @ResponseBody
    public SimpleMsg saveCollection(@RequestParam("to_id") Long to_id,
                                    @RequestParam("from_id") Long from_id) {


        Follow follow = new Follow();
        follow.to_id=to_id;
        follow.from_id=from_id;
        return followService.saveFollow(follow);
    }

}


