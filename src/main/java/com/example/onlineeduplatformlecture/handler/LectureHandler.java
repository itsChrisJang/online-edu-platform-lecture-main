package com.example.onlineeduplatformlecture.handler;

import com.example.onlineeduplatformlecture.model.Lecture;
import com.example.onlineeduplatformlecture.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class LectureHandler {

    /*Mono<ServerResponse> getLectureList(ServerRequest serverRequest);
    Mono<ServerResponse> getLecture(ServerRequest serverRequest);*/

    private final LectureService lectureService;
    // 강의 개설
    public Mono<ServerResponse> createLecture(ServerRequest request){
        /*
        String title = request.queryParam("title").orElse(null);

        if (StringUtils.isEmpty(title)) { // Required 비교
            return badRequest()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Mono.just(new RequiredException("title", "강의명은 필수값입니다.")), RequiredException.class);
        }*/
        Mono<Lecture> lectureMono = request.bodyToMono(Map.class)
                .flatMap(lectureService::createLecture)
                .log();

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(lectureMono, Lecture.class)
                .onErrorResume(error -> ServerResponse.badRequest().build());
    };
    /*
    Mono<ServerResponse> changeExposeLecture(ServerRequest serverRequest);

    Mono<ServerResponse> enrollLecture(ServerRequest serverRequest);

    Mono<ServerResponse> matchTeacher(ServerRequest serverRequest);

    Mono<ServerResponse> getContentList(ServerRequest serverRequest);
    Mono<ServerResponse> uploadContent(ServerRequest serverRequest);
    Mono<ServerResponse> getContent(ServerRequest serverRequest);

    Mono<ServerResponse> getScore(ServerRequest serverRequest);
    Mono<ServerResponse> setScore(ServerRequest serverRequest);

    Mono<ServerResponse> getRatingList(ServerRequest serverRequest);
    Mono<ServerResponse> getRating(ServerRequest serverRequest);
    Mono<ServerResponse> setRating(ServerRequest serverRequest);*/

}
