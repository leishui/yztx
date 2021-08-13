package com.example.yztx.controller;

import com.example.yztx.domain.Comment;
import com.example.yztx.domain.Reply;
import com.example.yztx.domain.User;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.service.CommentService;
import com.example.yztx.utils.Utils;
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
     * @return {"status":200,"msg":null,"content":{"content":[{"id":65,"type":0,"commentId":2,"comment_content":"魔iOS你明明哦婆婆婆婆在一起赶紧的P民自行你弟二二哦婆婆哦亲红蝶个哦呵呵呵呵额呵呵呵没给你你明明你明明哦婆婆婆婆你轰轰轰赶紧的P民自行你弟二二哦婆婆哦亲红蝶个哦呵呵呵呵额呵呵呵没给你你明明你明明哦婆婆婆婆你轰轰轰赶紧的P民自行你弟二二哦婆婆哦亲红蝶个哦呵呵呵呵额呵呵呵没给你你明明你明明哦婆婆婆婆你轰轰轰","comment_time":1628731083,"like_count":0,"reply_count":0,"commentator_id":3,"commentator_name":"国旭","commentator_url":"https://yztx.entergx.cn/resource/get?id=3&name=avartar.png","replies":{"content":[],"pageable":{"sort":{"sorted":true,"unsorted":false,"empty":false},"pageSize":3,"pageNumber":0,"offset":0,"paged":true,"unpaged":false},"last":true,"totalElements":0,"totalPages":0,"sort":{"sorted":true,"unsorted":false,"empty":false},"first":true,"numberOfElements":0,"size":3,"number":0,"empty":true}},{"id":64,"type":0,"commentId":2,"comment_content":"可口可口可乐了来了来了考虑考虑考虑考虑V5图啦啦啦可口可乐了看看可口可乐了看看可口可乐了看看可口可乐了看看考虑考虑考虑考虑拉拉裤突突突可乐了可口可乐了","comment_time":1628730957,"like_count":0,"reply_count":0,"commentator_id":3,"commentator_name":"国旭","commentator_url":"https://yztx.entergx.cn/resource/get?id=3&name=avartar.png","replies":{"content":[],"pageable":{"sort":{"sorted":true,"unsorted":false,"empty":false},"pageSize":3,"pageNumber":0,"offset":0,"paged":true,"unpaged":false},"last":true,"totalElements":0,"totalPages":0,"sort":{"sorted":true,"unsorted":false,"empty":false},"first":true,"numberOfElements":0,"size":3,"number":0,"empty":true}},{"id":60,"type":0,"commentId":2,"comment_content":"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n","comment_time":1628643263,"like_count":0,"reply_count":0,"commentator_id":3,"commentator_name":"国旭","commentator_url":"https://yztx.entergx.cn/resource/get?id=3&name=avartar.png","replies":{"content":[],"pageable":{"sort":{"sorted":true,"unsorted":false,"empty":false},"pageSize":3,"pageNumber":0,"offset":0,"paged":true,"unpaged":false},"last":true,"totalElements":0,"totalPages":0,"sort":{"sorted":true,"unsorted":false,"empty":false},"first":true,"numberOfElements":0,"size":3,"number":0,"empty":true}},{"id":54,"type":0,"commentId":2,"comment_content":"妈的\n","comment_time":1628317817,"like_count":0,"reply_count":0,"commentator_id":22,"commentator_name":"用户15978912182","commentator_url":"https://yztx.entergx.cn/resource/get?id=0&name=avatar.jpg","replies":{"content":[],"pageable":{"sort":{"sorted":true,"unsorted":false,"empty":false},"pageSize":3,"pageNumber":0,"offset":0,"paged":true,"unpaged":false},"last":true,"totalElements":0,"totalPages":0,"sort":{"sorted":true,"unsorted":false,"empty":false},"first":true,"numberOfElements":0,"size":3,"number":0,"empty":true}},{"id":37,"type":0,"commentId":2,"comment_content":"a","comment_time":1628299602,"like_count":0,"reply_count":0,"commentator_id":21,"commentator_name":"用户17742319999","commentator_url":"https://yztx.entergx.cn/resource/get?id=0&name=avatar.jpg","replies":{"content":[],"pageable":{"sort":{"sorted":true,"unsorted":false,"empty":false},"pageSize":3,"pageNumber":0,"offset":0,"paged":true,"unpaged":false},"last":true,"totalElements":0,"totalPages":0,"sort":{"sorted":true,"unsorted":false,"empty":false},"first":true,"numberOfElements":0,"size":3,"number":0,"empty":true}},{"id":35,"type":0,"commentId":2,"comment_content":"1","comment_time":1628299570,"like_count":0,"reply_count":0,"commentator_id":21,"commentator_name":"用户17742319999","commentator_url":"https://yztx.entergx.cn/resource/get?id=0&name=avatar.jpg","replies":{"content":[],"pageable":{"sort":{"sorted":true,"unsorted":false,"empty":false},"pageSize":3,"pageNumber":0,"offset":0,"paged":true,"unpaged":false},"last":true,"totalElements":0,"totalPages":0,"sort":{"sorted":true,"unsorted":false,"empty":false},"first":true,"numberOfElements":0,"size":3,"number":0,"empty":true}},{"id":34,"type":0,"commentId":2,"comment_content":"。","comment_time":1628299555,"like_count":0,"reply_count":0,"commentator_id":21,"commentator_name":"用户17742319999","commentator_url":"https://yztx.entergx.cn/resource/get?id=0&name=avatar.jpg","replies":{"content":[],"pageable":{"sort":{"sorted":true,"unsorted":false,"empty":false},"pageSize":3,"pageNumber":0,"offset":0,"paged":true,"unpaged":false},"last":true,"totalElements":0,"totalPages":0,"sort":{"sorted":true,"unsorted":false,"empty":false},"first":true,"numberOfElements":0,"size":3,"number":0,"empty":true}},{"id":29,"type":0,"commentId":2,"comment_content":"１５７５３３６９８５７\n","comment_time":1628298768,"like_count":0,"reply_count":0,"commentator_id":23,"commentator_name":"用户15978912183","commentator_url":"https://yztx.entergx.cn/resource/get?id=0&name=avatar.jpg","replies":{"content":[],"pageable":{"sort":{"sorted":true,"unsorted":false,"empty":false},"pageSize":3,"pageNumber":0,"offset":0,"paged":true,"unpaged":false},"last":true,"totalElements":0,"totalPages":0,"sort":{"sorted":true,"unsorted":false,"empty":false},"first":true,"numberOfElements":0,"size":3,"number":0,"empty":true}},{"id":28,"type":0,"commentId":2,"comment_content":"１５７５３３６９８５７","comment_time":1628298727,"like_count":0,"reply_count":0,"commentator_id":23,"commentator_name":"用户15978912183","commentator_url":"https://yztx.entergx.cn/resource/get?id=0&name=avatar.jpg","replies":{"content":[],"pageable":{"sort":{"sorted":true,"unsorted":false,"empty":false},"pageSize":3,"pageNumber":0,"offset":0,"paged":true,"unpaged":false},"last":true,"totalElements":0,"totalPages":0,"sort":{"sorted":true,"unsorted":false,"empty":false},"first":true,"numberOfElements":0,"size":3,"number":0,"empty":true}},{"id":23,"type":0,"commentId":2,"comment_content":"","comment_time":1628233553,"like_count":0,"reply_count":0,"commentator_id":11,"commentator_name":"丑","commentator_url":"https://yztx.entergx.cn/resource/get?id=11&name=avatar.png","replies":{"content":[],"pageable":{"sort":{"sorted":true,"unsorted":false,"empty":false},"pageSize":3,"pageNumber":0,"offset":0,"paged":true,"unpaged":false},"last":true,"totalElements":0,"totalPages":0,"sort":{"sorted":true,"unsorted":false,"empty":false},"first":true,"numberOfElements":0,"size":3,"number":0,"empty":true}}],"pageable":{"sort":{"sorted":true,"unsorted":false,"empty":false},"pageSize":10,"pageNumber":0,"offset":0,"paged":true,"unpaged":false},"last":false,"totalElements":23,"totalPages":3,"sort":{"sorted":true,"unsorted":false,"empty":false},"first":true,"numberOfElements":10,"size":10,"number":0,"empty":false}}
     * @catalog 与子同行/评论
     * @title 获取包含回复的评论列表
     * @description 分页获取包含至多3个回复的评论列表
     * @method post
     * @url comment/get_comments_and_replies
     * @return_param status int 成功与否
     * @return_param msg String 信息
     * @return_param content Page<Comment<reply>>
     */
    @PostMapping("/comment/get_comments_and_replies")
    @ResponseBody
    public SimpleMsg getCommentsAndReplies(@RequestParam("comment_id") Long comment_id,
                                           @RequestParam("type") int type,
                                           @RequestParam("page") int page,
                                           @RequestParam("size") int size) {
        return commentService.getCommentsAndRepliesById(comment_id, type,
                PageRequest.of(page, size, Sort.Direction.DESC, "id"));
    }

    /**
     * showdoc
     *
     * @param comment_id 必选 Long 评论id
     * @param type       必选 int 类型（课程/贴子/短视频）
     * @param user_id    必选 Long 评论者id
     * @param content    必选 String 评论内容
     * @return {"status":200,"msg":"存储成功","content":null}
     * @catalog 与子同行/评论
     * @title 获取包含回复的评论列表
     * @description 发表评论
     * @method post
     * @url comment/save_comment
     * @return_param status int 成功与否
     * @return_param msg String 成功则返回存储成功，失败则返回失败原因
     */
    @PostMapping("/comment/save_comment")
    @ResponseBody
    public SimpleMsg saveComments(@RequestParam("comment_id") Long comment_id,
                                  @RequestParam("content") String content,
                                  @RequestParam("user_id") Long user_id,
                                  @RequestParam("type") int type) {
        Comment comment = new Comment();
        comment.comment_time = Utils.getTimeStamp();
        comment.commentId = comment_id;
        comment.comment_content = content;
        comment.type = type;
        comment.commentator_id = user_id;
        return commentService.saveComment(comment);
    }

    /**
     * showdoc
     *
     * @param comment_id 必选 Long 评论id
     * @param type       必选 int 类型（课程/贴子/短视频）
     * @param page       必选 int 第几页
     * @param size       必选 int 一页显示多少项
     * @return {"status":200,"msg":null,"content":{"content":[{"id":65,"type":0,"commentId":2,"comment_content":"魔iOS你明明哦婆婆婆婆在一起赶紧的P民自行你弟二二哦婆婆哦亲红蝶个哦呵呵呵呵额呵呵呵没给你你明明你明明哦婆婆婆婆你轰轰轰赶紧的P民自行你弟二二哦婆婆哦亲红蝶个哦呵呵呵呵额呵呵呵没给你你明明你明明哦婆婆婆婆你轰轰轰赶紧的P民自行你弟二二哦婆婆哦亲红蝶个哦呵呵呵呵额呵呵呵没给你你明明你明明哦婆婆婆婆你轰轰轰","comment_time":1628731083,"like_count":0,"reply_count":0,"commentator_id":3,"commentator_name":"国旭","commentator_url":"https://yztx.entergx.cn/resource/get?id=3&name=avartar.png","replies":null},{"id":64,"type":0,"commentId":2,"comment_content":"可口可口可乐了来了来了考虑考虑考虑考虑V5图啦啦啦可口可乐了看看可口可乐了看看可口可乐了看看可口可乐了看看考虑考虑考虑考虑拉拉裤突突突可乐了可口可乐了","comment_time":1628730957,"like_count":0,"reply_count":0,"commentator_id":3,"commentator_name":"国旭","commentator_url":"https://yztx.entergx.cn/resource/get?id=3&name=avartar.png","replies":null},{"id":60,"type":0,"commentId":2,"comment_content":"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n","comment_time":1628643263,"like_count":0,"reply_count":0,"commentator_id":3,"commentator_name":"国旭","commentator_url":"https://yztx.entergx.cn/resource/get?id=3&name=avartar.png","replies":null},{"id":54,"type":0,"commentId":2,"comment_content":"妈的\n","comment_time":1628317817,"like_count":0,"reply_count":0,"commentator_id":22,"commentator_name":"用户15978912182","commentator_url":"https://yztx.entergx.cn/resource/get?id=0&name=avatar.jpg","replies":null},{"id":37,"type":0,"commentId":2,"comment_content":"a","comment_time":1628299602,"like_count":0,"reply_count":0,"commentator_id":21,"commentator_name":"用户17742319999","commentator_url":"https://yztx.entergx.cn/resource/get?id=0&name=avatar.jpg","replies":null},{"id":35,"type":0,"commentId":2,"comment_content":"1","comment_time":1628299570,"like_count":0,"reply_count":0,"commentator_id":21,"commentator_name":"用户17742319999","commentator_url":"https://yztx.entergx.cn/resource/get?id=0&name=avatar.jpg","replies":null},{"id":34,"type":0,"commentId":2,"comment_content":"。","comment_time":1628299555,"like_count":0,"reply_count":0,"commentator_id":21,"commentator_name":"用户17742319999","commentator_url":"https://yztx.entergx.cn/resource/get?id=0&name=avatar.jpg","replies":null},{"id":29,"type":0,"commentId":2,"comment_content":"１５７５３３６９８５７\n","comment_time":1628298768,"like_count":0,"reply_count":0,"commentator_id":23,"commentator_name":"用户15978912183","commentator_url":"https://yztx.entergx.cn/resource/get?id=0&name=avatar.jpg","replies":null},{"id":28,"type":0,"commentId":2,"comment_content":"１５７５３３６９８５７","comment_time":1628298727,"like_count":0,"reply_count":0,"commentator_id":23,"commentator_name":"用户15978912183","commentator_url":"https://yztx.entergx.cn/resource/get?id=0&name=avatar.jpg","replies":null},{"id":23,"type":0,"commentId":2,"comment_content":"","comment_time":1628233553,"like_count":0,"reply_count":0,"commentator_id":11,"commentator_name":"丑","commentator_url":"https://yztx.entergx.cn/resource/get?id=11&name=avatar.png","replies":null}],"pageable":{"sort":{"sorted":true,"unsorted":false,"empty":false},"pageSize":10,"pageNumber":0,"offset":0,"paged":true,"unpaged":false},"last":false,"totalElements":23,"totalPages":3,"sort":{"sorted":true,"unsorted":false,"empty":false},"first":true,"numberOfElements":10,"size":10,"number":0,"empty":false}}
     * @catalog 与子同行/评论
     * @title 获取评论列表
     * @description 分页获取评论列表
     * @method post
     * @url comment/get_comments
     * @return_param status int 成功与否
     * @return_param msg String 信息
     * @return_param content Page<Comment>
     * @remark 此接口不返回回复列表
     */
    @PostMapping("/comment/get_comments")
    @ResponseBody
    public SimpleMsg getComments(@RequestParam("comment_id") Long comment_id,
                                 @RequestParam("type") int type,
                                 @RequestParam("page") int page,
                                 @RequestParam("size") int size) {
        return commentService.getComments(comment_id, type,
                PageRequest.of(page, size, Sort.Direction.DESC, "id"));
    }


    /**
     * showdoc
     *
     * @param father_id 必选 Long 父评论id
     * @param page      必选 int 第几页
     * @param size      必选 int 一页显示多少项
     * @return {"status":200,"msg":null,"content":{"content":[{"id":2,"reply_content":"test","reply_time":1627612320,"replyFather":2,"like_count":0,"replier_id":0,"replier_name":"用户不存在","replier_url":"https://yztx.entergx.cn/resource/get?id=0&name=avatar.jpg"},{"id":1,"reply_content":"222","reply_time":1,"replyFather":2,"like_count":1,"replier_id":0,"replier_name":"用户不存在","replier_url":"https://yztx.entergx.cn/resource/get?id=0&name=avatar.jpg"}],"pageable":{"sort":{"sorted":true,"unsorted":false,"empty":false},"pageSize":10,"pageNumber":0,"offset":0,"paged":true,"unpaged":false},"last":true,"totalElements":2,"totalPages":1,"sort":{"sorted":true,"unsorted":false,"empty":false},"first":true,"numberOfElements":2,"size":10,"number":0,"empty":false}}
     * @catalog 与子同行/评论
     * @title 获取回复列表
     * @description 分页获取回复列表
     * @method post
     * @url comment/get_replies
     * @return_param status int 成功与否
     */
    @PostMapping("/comment/get_replies")
    @ResponseBody
    public SimpleMsg getReplies(@RequestParam("father_id") Long father_id,
                                @RequestParam("page") int page,
                                @RequestParam("size") int size) {
        return commentService.getReplies(father_id,
                PageRequest.of(page, size, Sort.Direction.DESC, "id"));
    }

    /**
     * showdoc
     *
     * @param reply_id      必选 Long 回复id
     * @param replyFather   必选 Long 所评论的父评论id
     * @param replier_id    必选 Long 回复者id
     * @param reply_content 必选 String 回复内容
     * @return {"status":200,"msg":"存储成功","content":null}
     * @catalog 与子同行/评论
     * @title 获取包含回复的评论列表
     * @description 发表回复
     * @method post
     * @url comment/save_reply
     * @return_param status int 成功与否
     * @return_param msg String 成功则返回存储成功，失败则返回失败原因
     */
    @PostMapping("/comment/save_reply")
    @ResponseBody
    public SimpleMsg saveReply(@RequestParam("reply_id") Long reply_id,
                               @RequestParam("reply_content") String reply_content,
                               @RequestParam("replier_id") Long replier_id,
                               @RequestParam("replyFather") Long replyFather) {


        Reply reply = new Reply();
        reply.reply_time = Utils.getTimeStamp();
        reply.id = reply_id;
        reply.replier_id = replier_id;
        reply.reply_content = reply_content;
        reply.replyFather = replyFather;
        return commentService.saveReply(reply);
    }
}

