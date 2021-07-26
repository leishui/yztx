package com.example.yztx.repository;

import com.example.yztx.domain.Lesson;
import com.example.yztx.domain.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {
    @Query("SELECT max(post_id) from Post ")
    Long getMaxId();


}
