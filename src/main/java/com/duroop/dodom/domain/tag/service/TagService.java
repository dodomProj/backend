package com.duroop.dodom.domain.tag.service;

import com.duroop.dodom.domain.tag.entity.Tag;
import com.duroop.dodom.domain.tag.repository.TagRepository;
import com.duroop.dodom.exception.BusinessException;
import com.duroop.dodom.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public Tag getTagById(Long tagId){

        return existTagId(tagId);

    }

    private Tag existTagId(Long tagId) {
        Optional<Tag> optional = tagRepository.findById(tagId);
        return optional.orElseThrow(() -> new BusinessException(ExceptionCode.TAG_NOT_FOUND));
    }

    public Tag createTag(Tag tag) {

        return tagRepository.save(tag);
    }





}
