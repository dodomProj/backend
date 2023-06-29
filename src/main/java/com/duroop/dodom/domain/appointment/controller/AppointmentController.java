package com.duroop.dodom.domain.appointment.controller;

import com.duroop.dodom.domain.appointment.mapper.AppointmentMapper;
import com.duroop.dodom.domain.appointment.dto.AppointmentDto;
import com.duroop.dodom.domain.appointment.entity.Appointment;
import com.duroop.dodom.domain.appointment.service.AppointmentService;
import com.duroop.dodom.domain.appointmentTime.service.AppointmentTimeService;
import com.duroop.dodom.domain.counselor.entity.Counselor;
import com.duroop.dodom.domain.counselor.service.CounselorService;
import com.duroop.dodom.domain.result.service.ResultService;
import com.duroop.dodom.util.UriUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final AppointmentTimeService appointmentTimeService;
    private final ResultService resultService;
    private final AppointmentMapper appointmentMapper;
    private final CounselorService counselorService;
    private static final String DEFAULT_URI = "/appointments";

    @PostMapping
    public ResponseEntity<?> postAppointment(@Validated @RequestBody AppointmentDto.Post requestBody) {
        Counselor counselor = counselorService.findCounselor(requestBody.getCounselorId());
        Appointment appointment = appointmentMapper.appointmentPostToAppointment(requestBody, counselor);

        Appointment createdAppointment = appointmentService.createAppointment(appointment);
        resultService.createResult(createdAppointment.getAppointmentId(), requestBody.getType(), requestBody.getResult());
        appointmentTimeService.createAppointmentTime(createdAppointment.getAppointmentId(), requestBody.getTimeList());

        AppointmentDto.Response appointmentToAppointResponse = appointmentMapper.appointmentToAppointResponse(createdAppointment);
        URI uri = UriUtil.createUri(DEFAULT_URI, appointmentToAppointResponse.getAppointmentId());
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<?> getAppointment(@RequestParam(value = "appointmentId") Long appointmentId){

        AppointmentDto.reviewResponse response = appointmentService.getReviewAppointmentDto(appointmentId);
        return ResponseEntity.ok().body(response);
    }



}
