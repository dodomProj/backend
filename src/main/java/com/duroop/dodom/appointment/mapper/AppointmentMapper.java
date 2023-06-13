package com.duroop.dodom.appointment.mapper;

import com.duroop.dodom.appointment.dto.AppointmentDto;
import com.duroop.dodom.appointment.entity.Appointment;
import com.duroop.dodom.counselor.entity.Counselor;
import com.duroop.dodom.counselor.service.CounselorService;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {



    default Appointment appointmentPostToAppointment(AppointmentDto.Post requestBody, Counselor counselor){

        return Appointment.builder()
                .email(requestBody.getEmail())
                .date(requestBody.getDate())
                .inquiry(requestBody.getInquiry())
                .method(requestBody.getMethod())
                .counselor(counselor)
                .build();
    }

    AppointmentDto.Response appointmentToAppointResponse(Appointment createdAppointment);
}
