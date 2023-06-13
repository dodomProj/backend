package com.duroop.dodom.appointment.service;

import com.duroop.dodom.appointment.entity.Appointment;
import com.duroop.dodom.appointment.repository.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public Appointment createAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);

        return appointment;
    }
}
