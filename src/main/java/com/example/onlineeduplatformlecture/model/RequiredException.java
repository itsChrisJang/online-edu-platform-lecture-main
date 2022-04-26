package com.example.onlineeduplatformlecture.model;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequiredException {

    private String field;
    private String message;
}
