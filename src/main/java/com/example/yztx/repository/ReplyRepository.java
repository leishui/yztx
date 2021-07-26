package com.example.yztx.repository;


import com.example.yztx.domain.Comment;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReplyRepository {
    //添加一个评论
    int saveComment(Comment comment);

    //查询父级评论
    List<Comment> findByFatherIdNull(@Param("FatherId") Long ParentId);

    //查询一级回复
    List<Comment> findParentIdNotNull(@Param("id") Long id);

    //查询二级以及所有子集回复
    List<Comment> findByReplayId(@Param("childId") Long childId);

}
