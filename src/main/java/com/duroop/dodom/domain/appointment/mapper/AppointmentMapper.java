package com.duroop.dodom.domain.appointment.mapper;

import com.duroop.dodom.domain.appointment.dto.AppointmentDto;
import com.duroop.dodom.domain.appointment.entity.Appointment;
import com.duroop.dodom.domain.counselor.entity.Counselor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {



    default Appointment appointmentPostToAppointment(AppointmentDto.Post requestBody, Counselor counselor){

        return Appointment.builder()
                .email(requestBody.getEmail())
                .name(requestBody.getName())
                .contact(requestBody.getContact())
                .result(requestBody.getResult())
                .inquiry(requestBody.getInquiry())
                .method(requestBody.getMethod())
                .counselor(counselor)
                .build();
    }

    AppointmentDto.Response appointmentToAppointResponse(Appointment createdAppointment);
}
