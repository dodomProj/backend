package com.duroop.dodom.domain.appointment.service;

import com.duroop.dodom.domain.appointment.dto.AppointmentDto;
import com.duroop.dodom.domain.appointment.entity.Appointment;
import com.duroop.dodom.domain.appointment.repository.AppointmentRepository;
import com.duroop.dodom.domain.appointmentTime.service.AppointmentTimeService;
import com.duroop.dodom.domain.review.entity.Review;
import com.duroop.dodom.domain.review.service.ReviewService;
import com.duroop.dodom.email.EmailService;
import com.duroop.dodom.exception.BusinessException;
import com.duroop.dodom.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final EmailService emailService;
    private final ReviewService reviewService;

    @Transactional
    public Appointment createAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
        emailService.createEmail(appointment.getAppointmentId(), appointment.getEmail());
        return appointment;
    }


    public Appointment findAppointment(Long appointmentId) {
        return existAppointmentId(appointmentId);
    }

    private Appointment existAppointmentId(Long appointmentId) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(appointmentId);
        return optionalAppointment.orElseThrow(() -> new BusinessException(ExceptionCode.APPOINTMENT_NOT_FOUND));
    }

    public AppointmentDto.reviewResponse getReviewAppointmentDto(Long appointmentId) {
        Appointment appointment = existAppointmentId(appointmentId);
        boolean reviewExist = reviewService.existReviewByAppointmentId(appointment);

        long counselorId = appointment.getCounselor().getCounselorId();

        return AppointmentDto.reviewResponse.builder()
                .reviewExist(reviewExist)
                .counselorId(counselorId)
                .build();
    }
}
