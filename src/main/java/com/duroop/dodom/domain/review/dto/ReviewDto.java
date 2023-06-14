package com.duroop.dodom.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class ReviewDto {

    @AllArgsConstructor
    @Getter
    public static class Post{
        private String name;
        private double score;
        private String review;
        private String review1;
        private Boolean agree;

    }

    @AllArgsConstructor
    @Getter @Builder
    public static class Response {
        private String name;
        private String review;
        private LocalDateTime appointmentAt;
    }
}
