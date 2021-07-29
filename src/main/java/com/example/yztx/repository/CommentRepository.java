package com.example.yztx.repository;

import com.example.yztx.domain.Comment;
import com.example.yztx.domain.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    //查询评论列表
    Page<Comment> findById(Long id, Pageable pageable);

    Page<Comment> findByIdAndType(Long id, int type, Pageable pageable);

}