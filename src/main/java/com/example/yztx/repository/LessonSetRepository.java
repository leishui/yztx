package com.example.yztx.repository;

import com.example.yztx.domain.LessonSet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LessonSetRepository extends JpaRepository<LessonSet,Long> {
    Page<LessonSet> findAllByLessonType(int lessonType, Pageable p);
    Page<LessonSet> findAll(Pageable p);
}
