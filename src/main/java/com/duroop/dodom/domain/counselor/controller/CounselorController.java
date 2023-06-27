package com.duroop.dodom.domain.counselor.controller;

import com.duroop.dodom.domain.counselor.dto.CounselorDto;
import com.duroop.dodom.domain.counselor.entity.Counselor;
import com.duroop.dodom.domain.counselor.mapper.CounselorMapper;
import com.duroop.dodom.domain.counselor.service.CounselorService;
import com.duroop.dodom.domain.score.entity.Score;
import com.duroop.dodom.domain.tag.service.TagService;
import com.duroop.dodom.domain.tag.entity.Tag;
import com.duroop.dodom.util.UriUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/counselors")
@Validated
@RequiredArgsConstructor
@Slf4j
public class CounselorController {

    private final CounselorMapper counselorMapper;
    private final CounselorService counselorService;
    private final TagService tagService;
    public static final String DEFAULT_URI = "/counselors";


    @PostMapping
    public ResponseEntity postCounselor(@Validated @RequestBody CounselorDto.Post requestBody) {
        Tag tag = tagService.getTagById(requestBody.getTagId());
        Counselor counselor = counselorMapper.counselorPostToCounselor(requestBody, tag);
        counselor.setScore(new Score());

        Counselor createdCounselor = counselorService.createCounselor(counselor);
        URI uri = UriUtil.createUri(DEFAULT_URI, createdCounselor.getCounselorId());
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<?> getCounselorListByTag(@RequestParam(value = "tagId")Long tagId){
        List<CounselorDto.Response> response = counselorMapper.counselorListToResponse(counselorService.getCounselorList(tagId));


        return ResponseEntity.ok().body(response);
    }
}
