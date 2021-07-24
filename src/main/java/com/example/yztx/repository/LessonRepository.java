package com.example.yztx.repository;

import com.example.yztx.domain.Lesson;
import com.example.yztx.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson,Long> {
    //通过id获取资源文件名
    @Query("SELECT url FROM Resource where id=:id")
    String getUrl(Long id);
}
