package com.example.onlineeduplatformlecture.repository;

import com.example.onlineeduplatformlecture.model.Lecture;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;


@Component
public interface LectureRepository extends ReactiveCrudRepository<Lecture, Integer> {

    @Query("select MAX(lecture_id) from LECTURE")
    int getLastLectureId();

}
