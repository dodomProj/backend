package com.duroop.dodom.counselor.dto;

import com.duroop.dodom.counselor.entity.Counselor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.util.List;

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
