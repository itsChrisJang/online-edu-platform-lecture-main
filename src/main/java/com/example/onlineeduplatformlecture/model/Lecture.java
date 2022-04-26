package com.example.onlineeduplatformlecture.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(value = "LECTURE")
public class Lecture {

    @Id
    @Column(value = "lecture_id")
    private int lectureId;

    @Column(value = "title")
    private String title;

    @Column(value = "location")
    private String location;

    @Column(value = "exposed_yn")
    private int exposedYn;

    @Column(value = "created_at")
    private LocalDateTime createdAt;

    @Column(value = "updated_at")
    private LocalDateTime updatedAt;
}


