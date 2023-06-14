package com.duroop.dodom.domain.counselor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CounselorDto {

    @AllArgsConstructor
    @Getter
    public static class Post {
        private Integer career;
        private String introduce;
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
