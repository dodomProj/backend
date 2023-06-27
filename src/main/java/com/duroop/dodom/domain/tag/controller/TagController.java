package com.duroop.dodom.domain.tag.controller;

import com.duroop.dodom.domain.tag.dto.TagDto;
import com.duroop.dodom.domain.tag.entity.Tag;
import com.duroop.dodom.domain.tag.service.TagService;
import com.duroop.dodom.util.UriUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tags")
public class TagController {

    private final TagService tagService;
    private static final String DEFAULT_URI = "/tags";


    @PostMapping
    public ResponseEntity postTag(@Validated @RequestBody TagDto.Post requestBody) {
        Tag tag = Tag.builder()
                .tagName(requestBody.getTagName())
                .build();

        Tag createdTag = tagService.createTag(tag);
        URI uri = UriUtil.createUri(DEFAULT_URI, createdTag.getTagId());
        return ResponseEntity.created(uri).build();
    }
}
