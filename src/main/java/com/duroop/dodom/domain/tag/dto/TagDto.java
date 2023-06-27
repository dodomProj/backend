package com.duroop.dodom.domain.tag.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
public class TagDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Post{
        @NotBlank(message = "tagName must not be blank.")
        private String tagName;
    }
}
