package com.example.onlineeduplatformlecture.service.empl;

import com.example.onlineeduplatformlecture.model.Lecture;
import com.example.onlineeduplatformlecture.repository.LectureRepository;
import com.example.onlineeduplatformlecture.service.LectureService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class LectureServiceImpl implements LectureService {
    private LectureRepository lectureRepository;
    // 강의 개설
    @Override
    public Mono<Lecture> createLecture(Map<String, Object> param) {

        int lectureId = lectureRepository.getLastLectureId() + 1;
        String title = param.get("title").toString();
        String location = param.get("location").toString();
        return lectureRepository.save(
                new Lecture(lectureId, title, location, 0,  LocalDateTime.now(), LocalDateTime.now()));
    }
}
