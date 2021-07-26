package com.example.yztx.repository;

import com.example.yztx.domain.Post;
import com.example.yztx.domain.Stvd;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StvdRepository extends CrudRepository<Stvd,Long> {
    @Query("SELECT max(stvd_id) from Stvd")
    Long getMaxId();
    String getUrl(Long id);
    Stvd findLessonBytitle(String title);

}
