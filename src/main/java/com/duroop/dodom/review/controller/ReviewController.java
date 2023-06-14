package com.duroop.dodom.review.controller;

import com.duroop.dodom.appointment.entity.Appointment;
import com.duroop.dodom.appointment.service.AppointmentService;
import com.duroop.dodom.review.mapper.ReviewMapper;
import com.duroop.dodom.review.dto.ReviewDto;
import com.duroop.dodom.review.entity.Review;
import com.duroop.dodom.review.service.ReviewService;
import com.duroop.dodom.util.UriUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/reviews")
@RestController
@RequiredArgsConstructor
public class ReviewController {

    private static final String DEFAULT_URI = "/reviews";
    private final ReviewMapper reviewMapper;
    private final AppointmentService appointmentService;
    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity postReview(@RequestParam(value = "appointmentId") Long appointmentId,  @RequestBody ReviewDto.Post requestBody){

        Appointment appointment = appointmentService.findAppointment(appointmentId);

        reviewService.creatable(appointment);

        Review review = reviewMapper.reviewPostToReview(requestBody);
        review.setAppointment(appointment);

        Review createdReview = reviewService.createReview(review);
        URI uri = UriUtil.createUri(DEFAULT_URI, createdReview.getReviewId());

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<ReviewDto.Response>> getReviewList(){

        List<Review> reviewList = reviewService.getReviewList();
        List<ReviewDto.Response> response = reviewMapper.reviewListToResponse(reviewList);
        return ResponseEntity.ok().body(response);
    }


}
