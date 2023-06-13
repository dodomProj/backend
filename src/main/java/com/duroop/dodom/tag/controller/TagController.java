package com.duroop.dodom.tag.controller;

import com.duroop.dodom.tag.dto.TagDto;
import com.duroop.dodom.tag.entity.Tag;
import com.duroop.dodom.tag.service.TagService;
import com.duroop.dodom.util.UriUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity postTag(@Valid @RequestBody TagDto.Post requestBody) {
        Tag tag = Tag.builder()
                .tagName(requestBody.getTagName())
                .build();

        Tag createdTag = tagService.createTag(tag);
        URI uri = UriUtil.createUri(DEFAULT_URI, createdTag.getTagId());
        return ResponseEntity.created(uri).build();
    }
}
