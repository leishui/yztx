package com.example.yztx.controller;

import com.example.yztx.domain.Collection;
import com.example.yztx.domain.Comment;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.repository.CollectionRepository;
import com.example.yztx.service.CollectionService;
import com.example.yztx.utils.Utils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CollectionController {
    @Resource
    CollectionService collectionService;
    /**
     * showdoc
     *
     * @param user_id    必选 Long    发起收藏者id
     * @param user_name  必选 String  发起收藏者名字
     * @param type       必选 long    类型（帖子/短视频/课程）
     * @param status     必选 boolean 1收藏0取消收藏
     * @return {"status":200,"msg":{"content":[{"id":1,"comment_id":1,"comment_content":"1","comment_time":1111111,"like_count":1,"reply_count":1,"commentator_id":1,"commentator_name":"用户111","commentator_url":"1","replies":{"content":[{"id":1,"reply_id":1,"reply_content":"222","replyFather":1,"reply_time":1,"like_count":1,"replier_id":1,"replier_name":"用户111","replier_url":null}],"pageable":{"sort":{"sorted":true,"unsorted":false,"empty":false},"offset":0,"pageNumber":0,"pageSize":5,"unpaged":false,"paged":true},"totalElements":1,"totalPages":1,"last":true,"size":5,"number":0,"sort":{"sorted":true,"unsorted":false,"empty":false},"numberOfElements":1,"first":true,"empty":false}}],"pageable":{"sort":{"sorted":true,"unsorted":false,"empty":false},"offset":0,"pageNumber":0,"pageSize":5,"unpaged":false,"paged":true},"totalElements":1,"totalPages":1,"last":true,"size":5,"number":0,"sort":{"sorted":true,"unsorted":false,"empty":false},"numberOfElements":1,"first":true,"empty":false}}
     * @catalog 与子同行/收藏
     * @title 发起收藏
     * @description 收藏
     * @method post
     * @url collection/sava_collection
     * @return_param status int 成功与否
     * @return_param msg String 成功则返回收藏数据，失败则返回失败原因
     * @remark 此接口返回的收藏列表中无用户头像地址
     */


    @PostMapping("/collection/sava_collection")
    @ResponseBody
    public SimpleMsg saveCollection(@RequestParam("user_id") Long user_id,
                                  @RequestParam("user_name") String user_name,
                                  @RequestParam("type") Long type,
                                  @RequestParam("status") boolean status) {


        Collection collection = new Collection();
        collection.user_id=user_id;
        collection.status=status;
        collection.type=type;
        collection.user_name=user_name;
        collection.creat_time=Utils.getTimeStamp();
        return collectionService.saveCollection(collection);
    }

}
