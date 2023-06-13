package com.duroop.dodom.tag.service;

import com.duroop.dodom.counselor.entity.Counselor;
import com.duroop.dodom.exception.BusinessException;
import com.duroop.dodom.exception.ExceptionCode;
import com.duroop.dodom.tag.entity.Tag;
import com.duroop.dodom.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
