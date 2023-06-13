package com.duroop.dodom.appointment.service;

import com.duroop.dodom.appointment.entity.Appointment;
import com.duroop.dodom.appointment.repository.AppointmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class AppointmentTest{
    @Mock
    AppointmentRepository appointmentRepository = Mockito.mock(AppointmentRepository.class);

    @Test
    void createAppointment()
    {
        //Given
        AppointmentService appointmentService = new AppointmentService(appointmentRepository);

        LocalDateTime d = LocalDateTime.parse("2023-06-09 23:59:59",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        Appointment appointment = Appointment.builder()
                .appointmentId(1L)
                .email("user@gmail.com")
                .date(d)
                .inquiry("잘 부탁드립니다.")
                .method("call").build();

        //When
        appointmentService.createAppointment(appointment);
        Long createdAppointmentId = appointment.getAppointmentId();

        //Then
        Assertions.assertNotNull(createdAppointmentId);
    }
}