package com.example.yztx.controller;

import com.example.yztx.domain.Collection;
import com.example.yztx.domain.Comment;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.service.CollectionService;
import com.example.yztx.utils.Utils;
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
     * @catalog 与子同行/收藏
     * @title 发起收藏
     * @description 收藏
     * @method post
     * @url collection/save_collection
     * @return {"status":300,"msg":"上传失败，数据库错误","content":null}
     * @return_param status int 成功与否
     * @return_param msg String 成功则返回收藏成功，失败则返回失败原因
     * @return_param content null
     */


    @PostMapping("/collection/save_collection")
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
