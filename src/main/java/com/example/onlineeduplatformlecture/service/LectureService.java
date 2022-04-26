package com.example.onlineeduplatformlecture.service;

import com.example.onlineeduplatformlecture.dto.LectureRegisterResponse;
import com.example.onlineeduplatformlecture.model.Lecture;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface  LectureService {

    Mono<Lecture> createLecture(Map<String, Object> param);
}
