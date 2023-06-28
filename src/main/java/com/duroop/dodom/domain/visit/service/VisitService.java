package com.duroop.dodom.domain.visit.service;

import com.duroop.dodom.domain.visit.Repsotiroy.VisitRepository;
import com.duroop.dodom.domain.visit.entity.Visits;
import com.duroop.dodom.exception.BusinessException;
import com.duroop.dodom.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;

    public Visits addVisitCount() {
        Visits visits = getVisits();
        visits.setVisitCount(visits.getVisitCount() + 1);
        return visitRepository.save(visits);
    }

    private Visits getVisits() {
        Optional<Visits> visit = visitRepository.findById(1L);
        return visit.orElseGet(() -> Visits.builder().build());
    }
}
