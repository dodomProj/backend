package com.duroop.dodom.domain.appointment.service;

import com.duroop.dodom.domain.appointment.entity.Appointment;
import com.duroop.dodom.domain.appointment.repository.AppointmentRepository;
import com.duroop.dodom.domain.appointmentTime.service.AppointmentTimeService;
import com.duroop.dodom.email.EmailService;
import com.duroop.dodom.exception.BusinessException;
import com.duroop.dodom.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final EmailService emailService;

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
}
