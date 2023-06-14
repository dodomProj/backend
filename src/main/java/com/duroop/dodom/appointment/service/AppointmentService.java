package com.duroop.dodom.appointment.service;

import com.duroop.dodom.appointment.entity.Appointment;
import com.duroop.dodom.appointment.repository.AppointmentRepository;
import com.duroop.dodom.counselor.entity.Counselor;
import com.duroop.dodom.email.EmailService;
import com.duroop.dodom.exception.BusinessException;
import com.duroop.dodom.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final EmailService emailService;

    @Transactional
    public Appointment createAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
        log.info("email " + appointment.getEmail());
        log.info("email " + appointment.getAppointmentId());
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
}
