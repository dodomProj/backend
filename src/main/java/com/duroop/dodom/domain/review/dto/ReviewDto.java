package com.duroop.dodom.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

public class ReviewDto {

    @AllArgsConstructor
    @Getter
    public static class Post{
        @NotBlank(message = "name must not be blank.")
        private String name;
        @NotEmpty(message = "score must not be empty.") @Positive
        private double score;
        private String review;
        private String review1;
        @NotNull(message = "agree must not be null.")
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
