package com.example.yztx.repository;

import com.example.yztx.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {
    Page<Post> findAll(Pageable p);
}
