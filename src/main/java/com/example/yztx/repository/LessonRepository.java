package com.example.yztx.repository;

import com.example.yztx.domain.Lesson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface LessonRepository extends CrudRepository<Lesson,Long> {
    Page<Lesson> findAll(Pageable p);
    ArrayList<Lesson> findAllByLessonSetId(Long setId);
}
