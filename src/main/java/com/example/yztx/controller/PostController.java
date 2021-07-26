package com.example.yztx.controller;

import com.example.yztx.domain.Post;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.service.PostService;
import com.example.yztx.utils.Utils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class PostController {

    @Resource
    PostService postService;

    /**
     * showdoc
     *
     * @param name        必选 String 贴子名
     * @param content     必选 String 贴子内容
     * @param up_id       必选 Long 上传者id
     * @param source_type 必选 boolean 是否为原创
     * @param post_type   必选 Long 贴子分类
     * @return {"status":200,"msg":"存储成功"}
     * @catalog 与子同行/贴子
     * @title 上传贴子
     * @description 上传贴子
     * @method post
     * @url post/upload
     * @return_param status int 成功与否
     * @return_param msg String 成功则返回存储成功，失败则返回失败原因
     */
    @PostMapping(value = "/post/upload")
    @ResponseBody
    public SimpleMsg upload(@RequestParam("name") String name,
                            @RequestParam("content") String content,
                            @RequestParam("up_id") Long up_id,
                            @RequestParam("source_type") boolean source_type,
                            @RequestParam("post_type") Long post_type) {
        Post lesson = new Post();
        lesson.post_name = name;
        lesson.post_content = content;
        lesson.uploader_id = up_id;
        lesson.source_type = source_type;
        lesson.post_type = post_type;
        lesson.upload_time = Utils.getTimeStamp();
        return postService.save(lesson);
    }

    /**
     * showdoc
     *
     * @param name        必选 String 贴子名
     * @param id          必选 Long 贴子id
     * @param content     必选 String 贴子内容
     * @param source_type 必选 boolean 是否为原创
     * @param post_type   必选 Long 贴子分类
     * @return {"status":200,"msg":"存储成功"}
     * @catalog 与子同行/贴子
     * @title 更新贴子信息
     * @description 更新贴子信息
     * @method post
     * @url post/update_info
     * @return_param status int 成功与否
     * @return_param msg String 成功则返回存储成功，失败则返回失败原因
     */
    @PostMapping(value = "/post/update_info")
    @ResponseBody
    public SimpleMsg updateInfo(@RequestParam("name") String name,
                                @RequestParam("id") Long id,
                                @RequestParam("content") String content,
                                @RequestParam("source_type") boolean source_type,
                                @RequestParam("post_type") Long post_type) {
        Post post = postService.getById(id);
        post.post_id = id;
        post.post_name = name;
        post.post_content = content;
        post.source_type = source_type;
        post.post_type = post_type;
        post.upload_time = Utils.getTimeStamp();
        return postService.save(post);
    }

}
