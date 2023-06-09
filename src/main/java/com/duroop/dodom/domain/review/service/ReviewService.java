package com.duroop.dodom.domain.review.service;

import com.duroop.dodom.domain.appointment.entity.Appointment;
import com.duroop.dodom.domain.review.entity.Review;
import com.duroop.dodom.domain.review.repository.ReviewRepository;
import com.duroop.dodom.exception.BusinessException;
import com.duroop.dodom.exception.ExceptionCode;
import com.duroop.dodom.domain.score.service.ScoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ScoreService scoreService;

    public Review createReview(Review review) {
        scoreService.patchScore(review.getAppointment().getCounselor(), review.getScore());
        return reviewRepository.save(review);
    }

    public List<Review> getReviewList() {

        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");

        return reviewRepository.findAllByAgreeIsTrue(sort);
    }

    public void creatable(Appointment appointment) {
        Optional<Review> optional = reviewRepository.findReviewByAppointmentIs(appointment);
        if(optional.isPresent()){
            throw new BusinessException(ExceptionCode.REVIEW_EXIST);
        }
    }

    public boolean existReviewByAppointmentId(Appointment appointment) {
        Optional<Review> optional = reviewRepository.findReviewByAppointment(appointment);
        return optional.isPresent();
    }
}
