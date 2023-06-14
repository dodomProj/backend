package com.duroop.dodom.appointment.service;

import com.duroop.dodom.appointment.entity.Appointment;
import com.duroop.dodom.appointment.repository.AppointmentRepository;
import com.duroop.dodom.counselor.entity.Counselor;
import com.duroop.dodom.exception.BusinessException;
import com.duroop.dodom.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public Appointment createAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);

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
