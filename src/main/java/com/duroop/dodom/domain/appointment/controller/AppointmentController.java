package com.duroop.dodom.domain.appointment.controller;

import com.duroop.dodom.domain.appointment.mapper.AppointmentMapper;
import com.duroop.dodom.domain.appointment.dto.AppointmentDto;
import com.duroop.dodom.domain.appointment.entity.Appointment;
import com.duroop.dodom.domain.appointment.service.AppointmentService;
import com.duroop.dodom.domain.counselor.entity.Counselor;
import com.duroop.dodom.domain.counselor.service.CounselorService;
import com.duroop.dodom.util.UriUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/appointments")
@Validated
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final AppointmentMapper appointmentMapper;
    private final CounselorService counselorService;
    private static final String DEFAULT_URI = "/appointments";

    @PostMapping
    public ResponseEntity postAppointment(@Valid @RequestBody AppointmentDto.Post requestBody) {
        Counselor counselor = counselorService.findCounselor(requestBody.getCounselorId());
        Appointment appointment = appointmentMapper.appointmentPostToAppointment(requestBody, counselor);

        Appointment createdAppointment = appointmentService.createAppointment(appointment);
        AppointmentDto.Response appointmentToAppointResponse = appointmentMapper.appointmentToAppointResponse(createdAppointment);

        URI uri = UriUtil.createUri(DEFAULT_URI, appointmentToAppointResponse.getAppointmentId());
        return ResponseEntity.created(uri).build();
    }



}
