package com.duroop.dodom.domain.appointmentTime.service;

import com.duroop.dodom.domain.appointment.entity.Appointment;
import com.duroop.dodom.domain.appointment.service.AppointmentService;
import com.duroop.dodom.domain.appointmentTime.entity.AppointmentTime;
import com.duroop.dodom.domain.appointmentTime.repository.AppointmentTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentTimeService {

    private final AppointmentTimeRepository appointmentTimeRepository;
    private final AppointmentService appointmentService;

    public void createAppointmentTime(Long appointmentId, List<LocalDateTime> timeList) {
        Appointment appointment = appointmentService.findAppointment(appointmentId);
        for(LocalDateTime time : timeList){
            AppointmentTime appointmentTime = AppointmentTime.builder()
                    .time(time)
                    .appointment(appointment)
                    .build();

            appointmentTimeRepository.save(appointmentTime);

        }
    }
}
