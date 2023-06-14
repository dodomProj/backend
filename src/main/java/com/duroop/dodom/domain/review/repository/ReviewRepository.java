package com.duroop.dodom.domain.review.repository;

import com.duroop.dodom.domain.appointment.entity.Appointment;
import com.duroop.dodom.domain.review.entity.Review;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByAgreeIsTrue(Sort sort);

    Optional<Review> findReviewByAppointmentIs(Appointment appointment);
}
