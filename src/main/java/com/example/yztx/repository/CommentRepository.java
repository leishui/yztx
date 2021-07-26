package com.example.yztx.repository;

import com.example.yztx.domain.Comment;

import java.util.List;

public interface CommentRepository {

    //查询评论列表
    List<Comment> listComment();

    //保存评论
    int saveComment(Comment comment);

}