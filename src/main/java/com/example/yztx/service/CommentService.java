package com.example.yztx.service;

import com.example.yztx.constant.DefaultValues;
import com.example.yztx.constant.StatusType;
import com.example.yztx.domain.Comment;
import com.example.yztx.domain.Reply;
import com.example.yztx.domain.User;
import com.example.yztx.msg.SimpleMsg;
import com.example.yztx.repository.CommentRepository;
import com.example.yztx.repository.ReplyRepository;
import com.example.yztx.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommentService {
    @Resource
    CommentRepository commentRepository;
    @Resource
    ReplyRepository replyRepository;
    @Resource
    UserRepository userRepository;

    /**
     * 分页获取评论附带回复列表
     * @param id 评论id
     * @param pageable 分页参数
     * @return SimpleMsg
     */
    public SimpleMsg getCommentsAndRepliesById(Long id, Pageable pageable) {
        Page<Comment> comments = commentRepository.findById(id, pageable);
        comments.getContent().forEach(comment -> {
            Page<Reply> replies = replyRepository.findByReplyFather(id, PageRequest.of(0, 3, Sort.Direction.ASC, "id"));
            replies.getContent().forEach(reply -> {
                User user = userRepository.findUserByUserId(reply.replier_id);
                reply.replier_name = user == null ? "用户不存在" : user.user_name;
            });
            comment.replies = replies;
            User user = userRepository.findUserByUserId(comment.commentator_id);
            if (user == null) {
                comment.commentator_name = "用户不存在";
                comment.commentator_url = DefaultValues.DEFAULT_AVATAR;
            } else {
                comment.commentator_name = user.user_name;
                comment.commentator_url = user.avatar_url;
            }
        });
        return new SimpleMsg(StatusType.SUCCESSFUL, comments);
    }

    /**
     * 分页获取评论列表
     * @param commentId 评论id对应资源id
     * @param pageable 设置分页参数
     * @return SimpleMsg
     */
    public SimpleMsg getComments(Long commentId, Pageable pageable){
        Page<Comment> comments = commentRepository.findById(commentId, pageable);
        comments.getContent().forEach(comment -> {
            User user = userRepository.findUserByUserId(comment.commentator_id);
            if (user == null) {
                comment.commentator_name = "用户不存在";
                comment.commentator_url = DefaultValues.DEFAULT_AVATAR;
            } else {
                comment.commentator_name = user.user_name;
                comment.commentator_url = user.avatar_url;
            }
        });
        return new SimpleMsg(StatusType.SUCCESSFUL,comments);
    }
    /**
     * 分页获取回复列表
     * @param fatherId 父评论id
     * @param pageable 设置分页参数
     * @return SimpleMsg
     */
    public SimpleMsg getReplies(Long fatherId,Pageable pageable){
        Page<Reply> replies = replyRepository.findByReplyFather(fatherId, pageable);
        replies.getContent().forEach(reply -> {
            User user = userRepository.findUserByUserId(reply.replier_id);
            reply.replier_name = user == null ? "用户不存在" : user.user_name;
            reply.replier_url = user == null ? DefaultValues.DEFAULT_AVATAR: user.avatar_url;
        });
        return new SimpleMsg(StatusType.SUCCESSFUL,replies);
    }
}
