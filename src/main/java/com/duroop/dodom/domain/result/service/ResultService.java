package com.duroop.dodom.domain.result.service;

import com.duroop.dodom.domain.appointment.entity.Appointment;
import com.duroop.dodom.domain.appointment.service.AppointmentService;
import com.duroop.dodom.domain.result.entity.Result;
import com.duroop.dodom.domain.result.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final ResultRepository resultRepository;
    private final AppointmentService appointmentService;

    public void createResult(long appointmentId, String type, String result) {
        Appointment appointment = appointmentService.findAppointment(appointmentId);
        Result appointmentResult = Result.builder()
                .type(type)
                .result(result)
                .appointment(appointment)
                .build();

        resultRepository.save(appointmentResult);
    }
}
