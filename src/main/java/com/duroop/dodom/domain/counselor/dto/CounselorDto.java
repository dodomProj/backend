package com.duroop.dodom.domain.counselor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@Getter
public class CounselorDto {

    @AllArgsConstructor
    @Getter
    public static class Post {
        @Positive @NotNull(message = "career must not be null.")
        private Integer career;
        @NotBlank
        private String introduce;
        @Positive @NotNull(message = "tagId must not be null.")
        private Long tagId;

    }

    @Getter
    @Builder
    public static class Response {
        private Long counselorId;
        private Integer career;
        private String introduce;
        private double score;
    }
}
