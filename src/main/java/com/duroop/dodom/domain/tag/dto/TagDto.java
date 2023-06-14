package com.duroop.dodom.domain.tag.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public class TagDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Post{
        private String tagName;
    }
}
