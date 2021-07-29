package com.example.yztx.repository;

import com.example.yztx.domain.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ReplyRepository extends CrudRepository<Reply,Long> {
    Page<Reply> findByReplyFather(Long father_id, Pageable pageable);
}
