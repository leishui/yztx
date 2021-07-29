package com.example.yztx.controller;

import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.service.CommentService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CommentController {
    @Resource
    CommentService commentService;

    /**
     * showdoc
     *
     * @param comment_id 必选 Long 评论id
     * @param type       必选 int 类型（课程/贴子/短视频）
     * @param page       必选 int 第几页
     * @param size       必选 int 一页显示多少项
     * @return {"status":200,"msg":{"content":[{"id":1,"comment_id":1,"comment_content":"1","comment_time":1111111,"like_count":1,"reply_count":1,"commentator_id":1,"commentator_name":"用户111","commentator_url":"1","replies":{"content":[{"id":1,"reply_id":1,"reply_content":"222","replyFather":1,"reply_time":1,"like_count":1,"replier_id":1,"replier_name":"用户111","replier_url":null}],"pageable":{"sort":{"sorted":true,"unsorted":false,"empty":false},"offset":0,"pageNumber":0,"pageSize":5,"unpaged":false,"paged":true},"totalElements":1,"totalPages":1,"last":true,"size":5,"number":0,"sort":{"sorted":true,"unsorted":false,"empty":false},"numberOfElements":1,"first":true,"empty":false}}],"pageable":{"sort":{"sorted":true,"unsorted":false,"empty":false},"offset":0,"pageNumber":0,"pageSize":5,"unpaged":false,"paged":true},"totalElements":1,"totalPages":1,"last":true,"size":5,"number":0,"sort":{"sorted":true,"unsorted":false,"empty":false},"numberOfElements":1,"first":true,"empty":false}}
     * @catalog 与子同行/评论
     * @title 获取包含回复的评论列表
     * @description 分页获取包含至多3个回复的评论列表
     * @method post
     * @url comment/get_comments_and_replies
     * @return_param status int 成功与否
     * @return_param msg String 成功则返回评论与回复数据，失败则返回失败原因
     * @remark 此接口返回的回复列表中无用户头像地址
     */
    @PostMapping("/comment/get_comments_and_replies")
    @ResponseBody
    public SimpleMsg getCommentsAndReplies(@RequestParam("comment_id") Long comment_id,
                                           @RequestParam("type") int type,
                                           @RequestParam("page") int page,
                                           @RequestParam("size") int size) {
        return commentService.getCommentsAndRepliesById(comment_id, type,
                PageRequest.of(page, size, Sort.Direction.ASC, "id"));
    }

    /**
     * showdoc
     *
     * @param comment_id 必选 Long 评论id
     * @param type       必选 int 类型（课程/贴子/短视频）
     * @param page       必选 int 第几页
     * @param size       必选 int 一页显示多少项
     * @return {"status":200,"msg":{"content":[{"id":1,"comment_id":1,"comment_content":"1","comment_time":1111111,"like_count":1,"reply_count":1,"commentator_id":1,"commentator_name":"用户111","commentator_url":"1","replies":null}],"pageable":{"sort":{"sorted":true,"unsorted":false,"empty":false},"offset":0,"pageNumber":0,"pageSize":5,"unpaged":false,"paged":true},"totalPages":1,"totalElements":1,"last":true,"size":5,"number":0,"sort":{"sorted":true,"unsorted":false,"empty":false},"numberOfElements":1,"first":true,"empty":false}}
     * @catalog 与子同行/评论
     * @title 获取评论列表
     * @description 分页获取评论列表
     * @method post
     * @url comment/get_comments
     * @return_param status int 成功与否
     * @return_param msg String 成功则返回评论数据，失败则返回失败原因
     * @remark 此接口不返回回复列表
     */
    @PostMapping("/comment/get_comments")
    @ResponseBody
    public SimpleMsg getComments(@RequestParam("comment_id") Long comment_id,
                                 @RequestParam("type") int type,
                                 @RequestParam("page") int page,
                                 @RequestParam("size") int size) {
        return commentService.getComments(comment_id, type,
                PageRequest.of(page, size, Sort.Direction.ASC, "id"));
    }

    /**
     * showdoc
     *
     * @param father_id 必选 Long 父评论id
     * @param page      必选 int 第几页
     * @param size      必选 int 一页显示多少项
     * @return {"status":200,"msg":{"content":[{"id":1,"reply_id":1,"reply_content":"222","replyFather":1,"reply_time":1,"like_count":1,"replier_id":1,"replier_name":"用户111","replier_url":"1"}],"pageable":{"sort":{"sorted":true,"unsorted":false,"empty":false},"offset":0,"pageNumber":0,"pageSize":5,"unpaged":false,"paged":true},"totalPages":1,"totalElements":1,"last":true,"size":5,"number":0,"sort":{"sorted":true,"unsorted":false,"empty":false},"numberOfElements":1,"first":true,"empty":false}}
     * @catalog 与子同行/评论
     * @title 获取回复列表
     * @description 分页获取回复列表
     * @method post
     * @url comment/get_replies
     * @return_param status int 成功与否
     * @return_param msg String 成功则返回回复数据，失败则返回失败原因
     * @remark 此接口返回回复列表中有用户头像地址
     */
    @PostMapping("/comment/get_replies")
    @ResponseBody
    public SimpleMsg getReplies(@RequestParam("father_id") Long father_id,
                                @RequestParam("page") int page,
                                @RequestParam("size") int size) {
        return commentService.getReplies(father_id,
                PageRequest.of(page, size, Sort.Direction.ASC, "id"));
    }
}
