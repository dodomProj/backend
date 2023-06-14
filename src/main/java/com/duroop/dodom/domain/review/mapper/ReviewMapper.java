package com.duroop.dodom.domain.review.mapper;

import com.duroop.dodom.domain.review.dto.ReviewDto;
import com.duroop.dodom.domain.review.entity.Review;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    Review reviewPostToReview(ReviewDto.Post requestBody);

    default ReviewDto.Response reviewToResponse(Review review){

        return ReviewDto.Response.builder()
                .name(review.getName())
                .review(review.getReview())
                .appointmentAt(review.getAppointment().getCreatedAt())
                .build();
    }

    List<ReviewDto.Response> reviewListToResponse(List<Review> reviewList);
}
