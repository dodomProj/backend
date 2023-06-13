package com.duroop.dodom.counselor.service;

import com.duroop.dodom.counselor.repository.CounselorRepository;
import com.duroop.dodom.counselor.entity.Counselor;
import com.duroop.dodom.exception.BusinessException;
import com.duroop.dodom.exception.ExceptionCode;
import com.duroop.dodom.tag.entity.Tag;
import com.duroop.dodom.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CounselorService {
    private final CounselorRepository counselorRepository;
    private final TagService tagService;

    public Counselor createCounselor(Counselor counselor) {
        return counselorRepository.save(counselor);
    }

    public Counselor findCounselor(Long counselorId) {
        return existCounselorId(counselorId);
    }

    private Counselor existCounselorId(Long counselorId) {
        Optional<Counselor> optionalCounselor = counselorRepository.findById(counselorId);
        return optionalCounselor.orElseThrow(()-> new BusinessException(ExceptionCode.COUNSELOR_NOT_FOUND));
    }

    public List<Counselor> getCounselorList(Long tagId) {
        Tag tag = tagService.getTagById(tagId);

        Optional<List<Counselor>> optionals = counselorRepository.findAllByTag(tag);

        return optionals.orElseThrow(() -> new BusinessException(ExceptionCode.COUNSELOR_NOT_FOUND));

    }
}
