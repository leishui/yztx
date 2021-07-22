package com.example.yztx.repository;

import com.example.yztx.domain.Lesson;
import com.example.yztx.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson,Long> {
    @Query("SELECT max(lesson_id) from Lesson ")
    Long getMaxId();

    Lesson findLessonByName(String name);
}
